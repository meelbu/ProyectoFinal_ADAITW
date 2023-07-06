package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.entidad.Autor;
import com.example.ProyectoFinal.entidad.Libro;
import com.example.ProyectoFinal.servicio.AutorServicio;
import com.example.ProyectoFinal.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;


    @GetMapping("/libros")
    public String listarLibros(Model model, @Param("palabraClave")String palabraClave){
        List<Libro> libros = libroServicio.listarLibros(palabraClave);
        model.addAttribute("libros", libros);
        model.addAttribute("palabraClave", palabraClave);
        return "libros";
    }

    @GetMapping("/libros/new")
    public String AgregarLibro(Model model){
        Libro libro = new Libro();
        List<Autor> listaAutores = autorServicio.listarTodosLosAutores();
        model.addAttribute("libro", libro);
        model.addAttribute("autores", listaAutores);
        return "crear_libro";
    }

    @PostMapping("/libros")
    public String GuardarLibro(@ModelAttribute("libro") Libro libro, RedirectAttributes redirect){
        libroServicio.guardarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha sido agregado con éxito");
        return "redirect:/libros";
    }

    @GetMapping("/libros/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long id, Model model){

        Libro libro = libroServicio.obtenerLibroPorId(id);
        List<Autor> autores = autorServicio.listarTodosLosAutores();

        model.addAttribute("libro", libro);
        model.addAttribute("autores", autores);

        return "editar_libro";
    }

    @PostMapping("/libros/editar/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute("libro")
                                   Libro libro, Model model){
        Libro libro1 = libroServicio.obtenerLibroPorId(id);

        libro1.setIsbn(libro.getIsbn());
        libro1.setTitulo(libro.getTitulo());
        libro1.setAnioEdicion(libro.getAnioEdicion());
        libro1.setCantidadEjemplares(libro.getCantidadEjemplares());
        libro1.setCondicionEjemplar(libro.getCondicionEjemplar());
        libro1.setEjemplaresPrestados(libro.getEjemplaresPrestados());

        libroServicio.actualizarLibro(libro1);

        return "redirect:/libros";
    }

    @PostMapping("/eliminar/libro/{id}")
    public String eliminarLibro(@PathVariable Long id, RedirectAttributes redirect){

        Libro libro = libroServicio.obtenerLibroPorId(id);
        libroServicio.eliminarLibro(libro);

        redirect.addFlashAttribute("msgExito", "El libro ha sido eliminado");

        return "redirect:/libros";
    }
}

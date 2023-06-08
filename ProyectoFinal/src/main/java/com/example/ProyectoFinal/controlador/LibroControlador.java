package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.entidad.Libro;
import com.example.ProyectoFinal.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping("/listar")
    public String listarLibros(Model model){
        List<Libro> libros = libroServicio.listarLibros();

        model.addAttribute("libros", libros);
        return "lista";
    }

    @GetMapping("/new")
    public String AgregarLibro(Model model){
        Libro libro = new Libro();
        model.addAttribute("libro", libro);
        return "crear_libro";
    }

    @PostMapping("/save")
    public String GuardarLibro(@ModelAttribute("libro") Libro libro){
        libroServicio.guardarLibro(libro);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long isbn, Model model){

        model.addAttribute("libro", libroServicio.obtenerLibroPorIsbn(isbn));

        return "editar_libro";
    }

    @PostMapping("/editar/{id}")
    public String actualizarLibro(@PathVariable Long isbn, @ModelAttribute("libro")
                                   Libro libro, Model model){
        Libro libro1 = libroServicio.obtenerLibroPorIsbn(isbn);

        libro1.setIsbn(isbn);
        libro1.setTitulo(libro.getTitulo());
        libro1.setAnioEdicion(libro.getAnioEdicion());
        libro1.setCantidadEjemplares(libro.getCantidadEjemplares());

        libroServicio.actualizarLibro(libro1);

        return "redirect:/listar";
    }

    public String eliminarLibro(@PathVariable Long isbn){

        libroServicio.eliminarLibro(isbn);

        return "redirect:/listar";
    }
}

package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.entidad.Autor;
import com.example.ProyectoFinal.servicio.AutorServicio;
import com.example.ProyectoFinal.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;


    @GetMapping("/autores")
    public String listarAutores(Model model){
        List<Autor> autors = autorServicio.listarTodosLosAutores();
        model.addAttribute("autores", autors);
        return "autores";
    }

    @GetMapping("/autores/new")
    public String agregarAutor(Model model){
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "crear_autor";
    }

    @PostMapping("/autores")
    public String guardarAutor(@ModelAttribute("autor") Autor autor, RedirectAttributes redirect){
        autorServicio.guardarAutor(autor);

        redirect.addFlashAttribute("msgExito", "El autor ha sido agregado con exito");
        return "redirect:/autores";
    }

    @GetMapping("/autores/editar/{id}")
    public String mostrarFormEditar(@PathVariable Integer id, Model model){

        model.addAttribute("autor", autorServicio.obtenerAutorPorId(id));

        return "editar_autor";
    }

    @PostMapping("/autores/{id}")
    public String actualizarAutor(@PathVariable Integer id, @ModelAttribute("autor")
                                  Autor autor, Model model){
        Autor autor1 = autorServicio.obtenerAutorPorId(id);

        autor1.setId(id);
        autor1.setNombreAutor(autor.getNombreAutor());
        autor1.setApellidoAutor(autor.getApellidoAutor());
        autor1.setLugarFechaNacimiento(autor.getLugarFechaNacimiento());

        autorServicio.actualizarAutor(autor1);

        return "redirect:/autores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Integer id, RedirectAttributes redirect){

        Autor autor = autorServicio.obtenerAutorPorId(id);
        autorServicio.eliminarAutor(id);
        redirect.addFlashAttribute("msgExito", "El autor ha sido eliminado");

        return "redirect:/autores";
    }


}

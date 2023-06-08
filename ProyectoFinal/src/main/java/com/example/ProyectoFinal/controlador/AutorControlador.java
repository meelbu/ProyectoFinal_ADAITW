package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.entidad.Autor;
import com.example.ProyectoFinal.servicio.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping("/listar")
    public String listarAutores(Model model){
        List<Autor> autores = autorServicio.listarTodosLosAutores();

        model.addAttribute("autores", autores);
        return "lista";
    }

    @GetMapping("/new")
    public String AgregarAutor(Model model){
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "crear_autor";
    }

    @PostMapping("/save")
    public String GuardarAutor(@ModelAttribute("autor") Autor autor){
        autorServicio.guardarAutor(autor);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEditar(@PathVariable Integer id, Model model){

        model.addAttribute("autor", autorServicio.obtenerAutorPorId(id));

        return "editar_autor";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAutor(@PathVariable Integer id, @ModelAttribute("autor")
                                  Autor autor, Model model){
        Autor autor1 = autorServicio.obtenerAutorPorId(id);

        autor1.setId(id);
        autor1.setNombreAutor(autor.getNombreAutor());
        autor1.setApellidoAutor(autor.getApellidoAutor());
        autor1.setLugarFechaNacimiento(autor.getLugarFechaNacimiento());

        autorServicio.actualizarAutor(autor1);

        return "redirect:/listar";
    }

    public String eliminarAutor(@PathVariable Integer id){

        autorServicio.eliminarAutor(id);

        return "redirect:/listar";
    }


}

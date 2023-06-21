package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @Autowired
    private UsuarioServicio UserServicio;

    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("usuarios", UserServicio.listarUsuarios());
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
}

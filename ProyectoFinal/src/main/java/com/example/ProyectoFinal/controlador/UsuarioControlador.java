package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.dto.UsuarioDTO;
import com.example.ProyectoFinal.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioDTO retornarNuevoUsuarioDTO() {
        return new UsuarioDTO();
    }

    @GetMapping
    public String MostrarFormularioRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDTO usuarioDTO){
        usuarioServicio.guardar(usuarioDTO);
        return "redirect:/registro?exito";
    }

}

package com.example.ProyectoFinal.controlador;

import com.example.ProyectoFinal.servicio.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;


}

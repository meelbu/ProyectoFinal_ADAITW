package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.dto.UsuarioDTO;
import com.example.ProyectoFinal.entidad.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario guardar(UsuarioDTO usuarioDTO);

    public List<Usuario> listarUsuarios();

}

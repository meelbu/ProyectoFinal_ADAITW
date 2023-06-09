package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.dto.UsuarioDTO;
import com.example.ProyectoFinal.entidad.Rol;
import com.example.ProyectoFinal.entidad.Usuario;
import com.example.ProyectoFinal.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario guardar(UsuarioDTO usuarioDTO) {
       Usuario usuario = new Usuario(usuarioDTO.getNombre(),
               usuarioDTO.getApellido(),usuarioDTO.getEmail(),
               passwordEncoder.encode(usuarioDTO.getPassword()), Arrays.asList(new  Rol("ROLE_USER")));

        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }


    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

}

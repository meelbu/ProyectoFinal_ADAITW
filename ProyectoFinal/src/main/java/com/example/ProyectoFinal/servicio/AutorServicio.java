package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.entidad.Autor;

import java.util.List;

public interface AutorServicio {

    public List<Autor> listarTodosLosAutores();

    List<Autor> listarTodosLosAutores(String palabraClave);

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Integer id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarAutor(Autor autor);
}

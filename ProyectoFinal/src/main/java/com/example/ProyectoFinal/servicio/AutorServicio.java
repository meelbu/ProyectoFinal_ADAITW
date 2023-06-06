package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.entidad.Autor;

import java.util.List;

public interface AutorServicio {

    public List<Autor> listarTodosLosAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Integer id);

    public Autor ActualizarAutor(Autor autor);

    public void eliminarAutor(Integer id);
}

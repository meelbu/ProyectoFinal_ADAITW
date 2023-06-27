package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.entidad.Libro;

import java.util.List;

public interface LibroServicio {

  public List<Libro> listarLibros();

  List<Libro> listarLibros(String palabraClave);

  public Libro guardarLibro(Libro libro);

  public Libro obtenerLibroPorId(Long id);

  public Libro actualizarLibro(Libro libro);

  public void eliminarLibro(Libro libro);

}

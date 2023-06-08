package com.example.ProyectoFinal.servicio;

import com.example.ProyectoFinal.entidad.Autor;
import com.example.ProyectoFinal.entidad.Libro;
import com.example.ProyectoFinal.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicioImpl implements LibroServicio{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public Libro obtenerLibroPorIsbn(Long isbn) {
        return libroRepositorio.findById(isbn).get();
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Long isbn) {
libroRepositorio.delete(isbn);
    }
}

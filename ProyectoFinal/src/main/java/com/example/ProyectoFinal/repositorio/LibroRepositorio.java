package com.example.ProyectoFinal.repositorio;

import com.example.ProyectoFinal.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE"
    + " CONCAT(l.id,l.isbn,l.titulo,l.anioEdicion,l.cantidadEjemplares,l.condicionEjemplar,l.ejemplaresPrestados)"
            + " LIKE %?1%")
    public List<Libro> findAll(String palabraClave);

}

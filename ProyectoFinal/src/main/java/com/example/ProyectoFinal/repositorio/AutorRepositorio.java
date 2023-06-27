package com.example.ProyectoFinal.repositorio;

import com.example.ProyectoFinal.entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer> {

    @Query("SELECT a FROM Autor a WHERE"
            + " CONCAT(a.id,a.nombreAutor,a.apellidoAutor,a.lugarNacimiento,a.fechaNacimiento)"
            + " LIKE %?1%")
    public List<Autor> findAll(String palabraClave);
}

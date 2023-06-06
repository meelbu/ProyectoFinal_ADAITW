package com.example.ProyectoFinal.entidad;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_autor", length = 100, nullable = false)
    private String nombreAutor;

    @Column(name = "apellido_autor", length = 100, nullable = false)
    private String apellidoAutor;

    private LocalDateTime lugarFechaNacimiento;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Integer id, String nombreAutor, String apellidoAutor, LocalDateTime lugarFechaNacimiento, List<Libro> libros) {
        this.id = id;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.lugarFechaNacimiento = lugarFechaNacimiento;
        this.libros = libros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public LocalDateTime getLugarFechaNacimiento() {
        return lugarFechaNacimiento;
    }

    public void setLugarFechaNacimiento(LocalDateTime lugarFechaNacimiento) {
        this.lugarFechaNacimiento = lugarFechaNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}

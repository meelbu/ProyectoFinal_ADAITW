package com.example.ProyectoFinal.entidad;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;
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

    @Column(name = "lugarNacimiento", length = 100, nullable = false)
    private String lugarNacimiento;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    private LocalDate fechaNacimiento;


    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Integer id, String nombreAutor, String apellidoAutor, String lugarNacimiento, LocalDate fechaNacimiento, List<Libro> libros) {
        this.id = id;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = libros;
    }

    public Autor(String nombreAutor, String apellidoAutor, String lugarNacimiento, LocalDate fechaNacimiento, List<Libro> libros) {
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}

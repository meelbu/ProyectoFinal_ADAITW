package com.example.ProyectoFinal.entidad;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long id;
    @Column(name = "libro_isbn",nullable = false)
    private long isbn;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "anio", nullable = false)
    private Integer anioEdicion;

    @Column(name = "cantidad_Ejemplares", nullable = false)
    private Integer cantidadEjemplares;

    @Column(name = "condicion_Ejemplares", length = 50, nullable = false)
    private String condicionEjemplar;

    @Column(name = "ejemplares_prestados", length = 50, nullable = false)
    private Integer ejemplaresPrestados;


    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(Long id, Long isbn, String titulo, Integer anioEdicion, Integer cantidadEjemplares, String condicionEjemplar, Integer ejemplaresPrestados, Autor autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioEdicion = anioEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.condicionEjemplar = condicionEjemplar;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(Integer anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getCondicionEjemplar() {
        return condicionEjemplar;
    }

    public void setCondicionEjemplar(String condicionEjemplar) {
        this.condicionEjemplar = condicionEjemplar;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

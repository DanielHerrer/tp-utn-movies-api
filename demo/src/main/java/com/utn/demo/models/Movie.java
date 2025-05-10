package com.utn.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El Nombre de la Pelicula no puede estar vacio.")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;
    @NotBlank(message = "El Director de la Pelicula no puede estar vacio.")
    private String director;
    @Min(value=1985,message="El Anio de Lanzamiento de la Pelicula no puede ser menor a 1985")
    private Integer releaseYear;
    @NotBlank(message = "El Genero de la Pelicula no puede estar vacio")
    private String genre;
    // Permite realizar una alta y baja lógica para no eliminar completamente el valor de la BDD
    @Column(nullable = false)
    private Boolean active;

    public Movie() {
        this.active = true; // Setea el "activo" por defecto
    }

    public Movie(String name, String director, Integer releaseYear, String genre) {
        this.name = name;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.active = true; // Setea el "activo" por defecto
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

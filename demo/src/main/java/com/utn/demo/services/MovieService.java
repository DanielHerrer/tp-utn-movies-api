package com.utn.demo.services;

import com.utn.demo.exceptions.InvalidNameException;
import com.utn.demo.exceptions.InvalidYearException;
import com.utn.demo.models.Movie;
import com.utn.demo.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    // Evito usar @Autowired haciendo una practica mejor que es usar inyección por constructor.
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        // Verifica que no haya ninguna pelicula (activa o no) que tenga el mismo nombre
        if (movieRepository.existsByNameIgnoreCase(movie.getName())) {
            throw new InvalidNameException("Ya existe una Película con el Nombre: " + movie.getName());
        }
        // Verifica que el género no sea "documental" si el año es anterior a 1920
        if (movie.getReleaseYear() < 1920 && movie.getGenre().equalsIgnoreCase("documental")) {
            throw new InvalidYearException("No se permiten Documentales anteriores al año 1920");
        }
        // Verifica que el año de salida NO SUPERE al actual + 2 años
        int maxYear = LocalDate.now().getYear() + 2;
        if (movie.getReleaseYear() > maxYear) {
            throw new InvalidYearException("No se permiten Peliculas con un Año de Salida superior a " + maxYear);
        }
        // Si supera las verificaciones realiza el guardado correctamente
        return movieRepository.save(movie);
    }

    // Trae TODAS las Peliculas (activas o no activas)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll().stream()
                .toList();
    }

    // Trae todas las Peliculas "activas"
    public List<Movie> getAllMoviesActive() {
        return movieRepository.findAll().stream()
                .filter(Movie::getActive) // expresion lambda
                .toList();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMoviesByReleaseYear(Integer year) {
        return movieRepository.findMoviesByReleaseYear(year);
    }

    public Optional<Movie> updateMovie(Long id, Movie movie) {
        try {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if (optionalMovie.isPresent()) {
                Movie m = optionalMovie.get();
                m.setName(movie.getName());
                m.setDirector(movie.getDirector());
                m.setGenre(movie.getGenre());
                m.setReleaseYear(movie.getReleaseYear());
                m.setActive(movie.getActive());

                return Optional.of(movieRepository.save(m));
            } else {
                return Optional.empty();
            }
        } catch(Exception ex) {
            System.err.println("Error al actualizar: "+ex.getMessage());
            return Optional.empty();
        }
    }

    public boolean deleteMovieById(Long id) {
        try {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if (optionalMovie.isPresent()) {
                Movie movie = optionalMovie.get();
                movie.setActive(false);
                movieRepository.save(movie);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error al eliminar: "+ex.getMessage());
            return false;
        }

    }

}

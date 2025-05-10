package com.utn.demo.controllers;

import com.utn.demo.models.Movie;
import com.utn.demo.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500") // debe usarse x cada controller
@RestController
@RequestMapping("/movies")
public class MovieController {
    // Evito usar @Autowired haciendo una practica mejor que es usar inyección por constructor.
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody @Valid Movie movie) {
        Movie saved = movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return movies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(movies) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok) // .map(movie -> ResponseEntity.ok(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Movie>> getMoviesByRealeaseYear(@PathVariable Integer year) {
        List<Movie> movies = movieService.getMoviesByReleaseYear(year);
        return movies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(movies) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody @Valid Movie movie) {
        return movieService.updateMovie(id, movie)
                .map(ResponseEntity::ok) // .map(movie -> ResponseEntity.ok(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {

        boolean isDeleted = movieService.deleteMovieById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

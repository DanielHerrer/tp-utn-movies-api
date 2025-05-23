package com.utn.demo.repositories;

import com.utn.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findMoviesByReleaseYear(Integer year);
    boolean existsByNameIgnoreCase(String name);
}

package com.example.basic_spring_project.controller;

import com.example.basic_spring_project.model.Movie;
import com.example.basic_spring_project.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(@RequestParam(required = false) List<String> genre,
                                    @RequestParam(required = false) Double minRating,
                                    @RequestParam(required = false) Double maxRating,
                                    @RequestParam(required = false) List<Integer> year,
                                    @RequestParam(required = false) List<String> mpa) {
       return movieService.getAllMovies(genre, minRating, maxRating, year, mpa);

    }
}

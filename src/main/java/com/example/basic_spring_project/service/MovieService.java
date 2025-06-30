package com.example.basic_spring_project.service;

import com.example.basic_spring_project.model.Movie;
import com.example.basic_spring_project.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies(List<String> genre,
                                    Double minRating,
                                    Double maxRating,
                                    List<Integer> year,
                                    List<String> mpa){
        return movieRepository.findByFilter(genre,minRating,maxRating,year,mpa);

    }
}

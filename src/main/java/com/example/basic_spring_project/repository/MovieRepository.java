package com.example.basic_spring_project.repository;

import com.example.basic_spring_project.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("""
select m from Movie m where(:genre is null or exists (select g from m.genres where g IN :genres))
and (:minRating is null or m.rating >= :minRating)
and (:maxRating is null or m.rating <= :maxRating)
and (:year is null or m.releaseYear IN :year)
and (:mpa is null or m.mpa IN :mpa)
""")
    List<Movie> findByFilter(List<String> genre,
                              Double minRating,
                              Double maxRating,
                              List<Integer> year,
                             List<String> mpa);
}

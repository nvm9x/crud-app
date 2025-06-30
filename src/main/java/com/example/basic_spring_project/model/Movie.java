package com.example.basic_spring_project.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    private String title;
    @Column(name="release_year")
    private Integer releaseYear;

    private Double rating;
    private String genre;

    private String mpa;



}

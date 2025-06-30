package com.example.basic_spring_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Описание не может быть пустым")
    @Size (min=2, max = 1000, message = "Длина описания должна быть от 2 до 1000 символов")
    @Column(name = "description")
    private String description;
    @NotNull(message = "Идентификатор автора не указан")

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Column(name="created_at")
    private LocalDateTime createdAt;

//    private Set<Integer> likedUserIds= new HashSet<>();
}

package com.example.basic_spring_project.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class Post {
    private Integer id;

    @NotBlank(message = "Описание не может быть пустым")
    @Size (min=2, max = 1000, message = "Длина описания должна быть от 2 до 1000 символов")
    private String description;
    @NotNull(message = "Идентификатор автора не указан")
    private Integer authorId;

    private LocalDateTime createdAt;

    private Set<Integer> likedUserIds= new HashSet<>();
}

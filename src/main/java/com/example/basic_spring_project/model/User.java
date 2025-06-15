package com.example.basic_spring_project.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private int id;
    @NotBlank(message = "Почта пользователя не должна быть пуста")
    @Size(min=2, max=120, message = "Длина имя пользователя должна быть от 2 до 120 символов")
    private String name;
    @NotBlank(message = "Почта пользователя не должна быть пуста")
    @Email(message = "Почта пользователя должна быть в формате \"user@mail.com\"")
    private String email;


}

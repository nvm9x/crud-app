package com.example.basic_spring_project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "Почта пользователя не должна быть пуста")
    @Size(min=2, max=120, message = "Длина имя пользователя должна быть от 2 до 120 символов")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Почта пользователя не должна быть пуста")
    @Email(message = "Почта пользователя должна быть в формате \"user@mail.com\"")
     @Column(name = "email")
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {

    }
}

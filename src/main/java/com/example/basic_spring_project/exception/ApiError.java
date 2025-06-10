package com.example.basic_spring_project.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private final String error;
    private final LocalDateTime timestamp;
}

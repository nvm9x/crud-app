package com.example.basic_spring_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*    @ExceptionHandler
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex){
       *//* Map<String,Object> map = new HashMap<>();
        map.put("error", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());*//* //больше не надо
        ApiError apiError = new ApiError(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

        }*/ //1 вариант


    //2 вариант
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(NotFoundException ex){
        return new ApiError(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflict(ConflictException ex){
        return new ApiError(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentValid(MethodArgumentNotValidException ex){
        String message = ex.getFieldErrors()
                .stream()
                .findFirst()
                .map(fieldError -> fieldError.getDefaultMessage())
                .orElse("Неизвестная ошибка");
        return new ApiError(message,LocalDateTime.now());
    }



}

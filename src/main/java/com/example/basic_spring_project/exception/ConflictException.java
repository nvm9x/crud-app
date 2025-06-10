package com.example.basic_spring_project.exception;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}

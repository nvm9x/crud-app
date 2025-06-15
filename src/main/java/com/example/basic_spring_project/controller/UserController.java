package com.example.basic_spring_project.controller;

import com.example.basic_spring_project.exception.ApiError;
import com.example.basic_spring_project.exception.ConflictException;
import com.example.basic_spring_project.exception.NotFoundException;
import com.example.basic_spring_project.model.User;
import com.example.basic_spring_project.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService; //объект юзерсервиса


    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
    //CRUD приложение
    //create,read,update,delete

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

//    @GetMapping("/{userId}")
//    public void likedPosts(@PathVariable int userId,@PathVariable int postId){
//         userService.addlikedPosts(userId,postId);
//    }


}









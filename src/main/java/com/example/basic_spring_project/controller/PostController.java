package com.example.basic_spring_project.controller;

import com.example.basic_spring_project.model.Post;
import com.example.basic_spring_project.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;


    @GetMapping
    public List<Post> getAllPosts(@RequestParam(required = false)Integer authorId){
        return postService.getAllPosts(authorId);
    }

    @PostMapping
    public Post create(@Valid @RequestBody Post post){
        return postService.create(post);
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        postService.deletePost(id);
    }

    @PatchMapping("/{id}")
    public Post update(@PathVariable int id, @RequestBody Post post){
        return postService.update(id,post);
    }

    @PutMapping("/{userId}")
    public void addLike(@PathVariable int userId, @PathVariable int postId) {
         postService.addLike(userId,postId);
    }
}

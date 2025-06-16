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
    public List<Post> getAllPosts(@RequestParam(required = false)Integer authorId,
                                  @RequestParam(required = false) String sortBy,
    @RequestParam (required=false) String direction){
        return postService.getAllPosts(authorId,sortBy,direction);
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

    @PutMapping("/{postId}/likes/{userId}")
    public void addLike(@PathVariable int userId, @PathVariable int postId) {
         postService.addLike(userId,postId);
    }

    @GetMapping("/liked-posts")
    public List<Post> getLikedPosts(@RequestParam int userId) {
        return postService.getLikedPosts(userId);

    }

    @DeleteMapping("/{postId}/likes/{userId}")
    public void deleteLike(@PathVariable int userId, @PathVariable int postId) {
         postService.deleteLike(userId,postId);
    }
}

package com.example.basic_spring_project.service;

import com.example.basic_spring_project.exception.NotFoundException;
import com.example.basic_spring_project.model.Post;
import com.example.basic_spring_project.model.User;
import com.example.basic_spring_project.repository.PostRepository;
import com.example.basic_spring_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<Post> getAllPosts(Integer authorId){
      return postRepository.getAllPosts(authorId);
    }
    public Post create(Post post){
        //при создании поста проверить существует ли автор
       userRepository.findById(post.getAuthorId()).orElseThrow(()-> new NotFoundException("Автор не найден"));

        post.setCreatedAt(LocalDateTime.now());
        return postRepository.create(post);
    }

    public Post findById(int id){

        return postRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Пост не найден"));
    }

    public void deletePost(int id){
     postRepository.deletePost(id);
    }

    public Post update(int id, Post post){
        Post postFound = findById(id);
        if(post.getDescription()!=null){
            postFound.setDescription(post.getDescription());
        }
        return postFound;
    }

    public void addLike(int userId, int postId){
        postRepository.addLikes(userId,postId);
        userRepository.addlikedPosts(userId,postId);
    }


}

package com.example.basic_spring_project.repository;

import com.example.basic_spring_project.model.Post;
import com.example.basic_spring_project.service.UserService;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();
    private int nextId;
    public List<Post> getAllPosts(Integer authorId){
        if (authorId!=null){
          return posts.stream()
                    .filter(post -> post.getAuthorId().equals(authorId))
                    .toList();
        }
        return posts;
    }

    public Post create(Post post){
        post.setId(++nextId);
        posts.add(post);
        return post;
    }

    public Optional<Post> findById(int id){
        return posts.stream()
                .filter(post -> post.getId()==id)
                .findFirst();
    }

    public void deletePost(int id){
        Post postTodelte=null;
        for(Post post: posts){
            if(post.getId()==id){
                postTodelte=post;
                break;
            }
        }
        posts.remove(postTodelte);
    }

    public void deleteByAuthorId(Integer authorId){
        List<Post> postsToDelete = new ArrayList<>();
        for(Post post:posts){
            if(post.getAuthorId().equals(authorId)){
                postsToDelete.add(post);
            }
        }
        posts.removeAll(postsToDelete);
    }

    public void addLikes(int userId, int postId){
        Post post = null;
        for(Post p:posts){
            if(p.getId().equals(postId)){
                post=p;
                break;
            }
        }
        //попытка добавить юзера в список лайков у поста
        if(post!=null){
            post.getLikedUserIds().add(userId);
        }

    }
    }



package com.example.basic_spring_project.repository;

import com.example.basic_spring_project.model.Post;
import com.example.basic_spring_project.service.UserService;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();
    private int nextId;
    public List<Post> getAllPosts(Integer authorId, String sortBy,String direction){
        List<Post> sortedPosts = new ArrayList<>();
        if (authorId!=null){
            for(Post p:posts){
                if(p.getAuthorId().equals(authorId)){
                    sortedPosts.add(p);
                }
            }



        } if("likes".equalsIgnoreCase(sortBy)){
            sortedPosts.sort(new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    int result=  Integer.compare(o1.getLikedUserIds().size(),o2.getLikedUserIds().size());

                    return "asc".equalsIgnoreCase(direction) ? result : -result;
                }
            });

        } else if ("date".equalsIgnoreCase(sortBy)) {
            sortedPosts.sort(new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    int result= o1.getCreatedAt().compareTo(o2.getCreatedAt());
                    return "asc".equalsIgnoreCase(direction) ? result : -result;
                }
            });

        }
        return sortedPosts;
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

    public List<Post> getLikedPost(int userId){
        List<Post> likedPosts = new ArrayList<>();
        for(Post p:posts){
            if(p.getLikedUserIds().contains(userId)){
                likedPosts.add(p);

            }
        }
        return likedPosts;
    }

    public void deleteLike(int userId,int postId){
        for(Post p:posts){
            if(p.getId().equals(postId)){
                p.getLikedUserIds().remove(userId);
            }
        }
    }
    }



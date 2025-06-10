package com.example.basic_spring_project.repository;

import com.example.basic_spring_project.exception.ConflictException;
import com.example.basic_spring_project.exception.NotFoundException;
import com.example.basic_spring_project.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private int nextId;
    public List<User> getAllUsers(){
        return users;
    }



    public User create(User user){

        user.setId(++nextId);
        users.add(user);
        return user;
    }

    public Optional<User>  findById(int id){

        return users.stream()
                .filter(u->u.getId()==id)
                .findFirst();

    }


    public void deleteUser(int id){
        User userToDelete = null;
        for (User user:users) {
            if(user.getId() == id){
                userToDelete=user;
                break;
            }

        }
        users.remove(userToDelete);
    }

    public void addlikedPosts(int postId,int userId){
        User user=null;
        for(User u:users){
            if(u.getId()==userId){
                user=u;
                break;
            }
        }
        user.getLikedPosts().add(postId);


    }


}

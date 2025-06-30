package com.example.basic_spring_project.repository;

import com.example.basic_spring_project.exception.ConflictException;
import com.example.basic_spring_project.exception.NotFoundException;
import com.example.basic_spring_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
//    private List<User> users = new ArrayList<>();
//    private int nextId;
//    public List<User> getAllUsers(){
//        return users;
//    }
    Optional<User> findByEmail(String str);
    List<User> findByName(String str);

    List<User> findByIdIn(List<Integer> userIds);


//
//    public User create(User user){
//
//        user.setId(++nextId);
//        users.add(user);
//        return user;
//    }
//
//    public Optional<User>  findById(int id){
//
//        return users.stream()
//                .filter(u->u.getId()==id)
//                .findFirst();
//
//    }
//
//
//    public void deleteUser(int id){
//        User userToDelete = null;
//        for (User user:users) {
//            if(user.getId() == id){
//                userToDelete=user;
//                break;
//            }
//
//        }
//        users.remove(userToDelete);
//    }



    }




package com.example.basic_spring_project.service;

import com.example.basic_spring_project.exception.BadRequestException;
import com.example.basic_spring_project.exception.ConflictException;
import com.example.basic_spring_project.exception.NotFoundException;
import com.example.basic_spring_project.model.User;
import com.example.basic_spring_project.repository.PostRepository;
import com.example.basic_spring_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service //создает объект сервиса,делает бином
@RequiredArgsConstructor
public class UserService {
    //private List<User> users = new ArrayList<>();
    //private int nextId;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<User> getAllUsers(List<Integer> userIds){
        if(userIds==null){
           return userRepository.findAll();
        } else {
            return userRepository.findByIdIn(userIds);
        }
    }
    //CRUD
    //create,read,update,delete


    public User create(User user){

        //Проверка если почта занята выбрасываем исключение
       Optional<User> optional=  userRepository.findByEmail(user.getEmail());
       if(optional.isPresent()){
           throw new ConflictException("Почта занята");
       }
     return userRepository.save(user);
    }

    public User findById(int id){
       /* for(User user: users){
            if(user.getId() == id){
                return user;
            }
        }return null;*/
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Пользователь не найден"));
    }


    public void deleteUser(int id){
//    postRepository.deleteByAuthorId(id);
//      userRepository.deleteUser(id);
    }

    public User update(int id, User user){

       User userFound= findById(id);

       if(user.getName()!=null){
           userFound.setName(user.getName());
       }
        if(user.getEmail()!=null){
            userFound.setEmail(user.getEmail());
        }


        return userFound;
    }






}

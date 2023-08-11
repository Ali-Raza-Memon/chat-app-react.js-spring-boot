package com.fastech.chatapp.service;

import com.fastech.chatapp.model.User;
import com.fastech.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
        System.out.println("A service is called...");
        System.out.println(user.getUsername());
        User oldUser = userRepository.findUserByUsername(user.getUsername());
        if(oldUser != null){
            oldUser.setActive(true);
            userRepository.save(oldUser);
            return ("Welcome back to Chat App!");
        }
        else {
            user.setActive(true);
            user.setCreatedAt(new Date());
            userRepository.save(user);
            return "Your username is added!";
        }
    }

    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    public List<String> findNamesOfActiveUsers(){
        return userRepository.findNamesOfActiveUsers();
    }

}

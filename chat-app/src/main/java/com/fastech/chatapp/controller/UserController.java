package com.fastech.chatapp.controller;

import com.fastech.chatapp.service.UserService;
import com.fastech.chatapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        System.out.println("Hello. you have called it!");
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }

//    @GetMapping("/findUserAndAdd")
//    public ResponseEntity<?> findUserAndAdd(@RequestBody User user){
//        System.out.println("I'm from User Controller");
//        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserAndAdd(user));
//    }

    @GetMapping("/activeUsers")
    public ResponseEntity<?> findNamesOfActiveUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findNamesOfActiveUsers());
    }

    @GetMapping("/findUserById")
    public ResponseEntity<?> findUserById(@RequestParam Long id){
        System.out.println("I'm from User Controller");
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }


}

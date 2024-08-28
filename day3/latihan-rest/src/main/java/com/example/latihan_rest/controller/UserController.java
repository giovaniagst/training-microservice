package com.example.latihan_rest.controller;

import com.example.latihan_rest.entity.User;
import com.example.latihan_rest.entity.UserResponse;
import com.example.latihan_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public UserResponse getUser() {
        return userService.getUsers();
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "success";
    }
}

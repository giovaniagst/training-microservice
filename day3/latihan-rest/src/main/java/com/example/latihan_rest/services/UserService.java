package com.example.latihan_rest.services;

import com.example.latihan_rest.entity.User;
import com.example.latihan_rest.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<User>() {
        {
            add(new User("1", "Budi"));
        }
    };

    public UserResponse getUsers() {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsers(users);
        return userResponse;
    }

    public void addUser(User user) {
        users.add(user);
    }
}

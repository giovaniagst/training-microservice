package com.example.latihan_rest.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    List<User> users;
}

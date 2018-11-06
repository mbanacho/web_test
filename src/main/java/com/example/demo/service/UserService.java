package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser() {
        User user = new User("A","b",1);
        return user;
    }
}

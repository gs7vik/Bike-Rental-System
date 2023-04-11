package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.thoughtclan.bikerentalsystem.services.UserService;
import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody UserRegistrationDto registrationDto) {
        return userService.saveUser(registrationDto);


    }
}
package com.thoughtclan.bikerentalsystem.controllers;


import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.services.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public UserOutputDto createUser(@RequestBody UserInputDto user){
        return userService.saveUser(user);
    }

    public boolean verifyUser(@RequestBody UserInputDto user){
        return true;
    }

    @GetMapping("/{id}")
    public UserOutputDto getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserOutputDto> updateUser(@PathVariable Long id,@RequestBody UserInputDto input){
       return userService.updateUser(id,input);
    }

    @PostMapping("/login")
    public LoginOutputDto login(@RequestBody LoginInputDto input){
        return userService.login(input);
    }

    @GetMapping("/me")
    public UserOutputDto userMe(){return userService.userMe();}

    @GetMapping("/userBookings/{id}")
    public List<BookingOutputDto> getUserBookings(@PathVariable Long id){
        return userService.getUserBookings(id);
    }
}

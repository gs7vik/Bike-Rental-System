package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
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


    public boolean verifyUser(@RequestBody UserInDto user){
        return true;
    }

    @GetMapping("/{id}")
    public UserOutDto getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PatchMapping("/partialupdate/{id}")
    public UserOutDto partialUpdateUser(@RequestBody UserInDto input, @PathVariable Long id){
        return userService.partialUpdateUser(input,id);
    }
    @PutMapping("/update/{id}")
    public UserOutDto updateUser(@RequestBody UserInDto input,@PathVariable Long id){
        return userService.updateUser(id,input);
    }
    @PostMapping("/login")
    public LoginOutputDto login(@RequestBody LoginInputDto input){
        return userService.login(input);
    }

    @PatchMapping("/{id}")
    public UserOutDto partialUpdateUser(@PathVariable Long id,@RequestBody UserInDto user){
        return userService.partialUpdate(id,user);
    }

    @GetMapping("/me")
    public UserOutDto userMe(){
        return userService.userMe();
    }

    @PatchMapping("{userId}/map-role")
    public UserOutDto mapRoleToUser(@PathVariable Long userId, @RequestParam Long roleId){
        return userService.mapRole(userId, roleId);
    }
}
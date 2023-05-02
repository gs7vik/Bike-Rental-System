package com.thoughtclan.bikerentalsystem.controllers;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.services.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PatchMapping("/partialupdate/{id}")
    public UserOutDto partialUpdateUser(@RequestBody UserInDto input, @PathVariable Long id){
        return userService.partialUpdateUser(input,id);
    }
    @PutMapping("/update/{id}")
    public UserOutDto updateUser(@RequestBody UserInDto input,@PathVariable Long id){
        return userService.updateUser(id,input);
    }
//    @PatchMapping("/{id}")
//    public UserOutDto partialUpdateUser(@PathVariable Long id,@RequestBody UserInDto user){
//        return userService.partialUpdate(id,user);
//    }
@DeleteMapping("/{id}")
public ResponseEntity<UserOutputDto> deleteUserById(@PathVariable Long id){return userService.deleteUser(id);}

    @PostMapping("/login")
    public LoginOutputDto login(@RequestBody LoginInputDto input){
        return userService.login(input);
    }

    @GetMapping("/me")
    public UserOutputDto userMe(){return userService.userMe();}





}


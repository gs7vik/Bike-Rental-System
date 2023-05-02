package com.thoughtclan.bikerentalsystem.services;


import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.models.User;

public interface UserService {
    LoginOutputDto login(LoginInputDto input);

    User getByFireBaseId(String uid);

    User saveUser(UserRegistrationDto registrationDto);


    public UserOutDto getUser(Long id);


    UserOutDto partialUpdateUser(UserInDto input, Long id);

    UserOutDto updateUser(Long id, UserInDto input);

    //public LoginDto login(LoginInputDto input);

    UserOutDto userMe();
}

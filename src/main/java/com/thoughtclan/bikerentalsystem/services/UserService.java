package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;

public interface UserService {
    User saveUser(UserRegistrationDto registrationDto);


    public UserOutDto getUser(Long id);

    public LoginOutputDto login(LoginInputDto input);

}

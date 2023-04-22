package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.models.User;

public interface UserService {
    User saveUser(UserRegistrationDto registrationDto);


    public UserOutDto getUser(Long id);
}

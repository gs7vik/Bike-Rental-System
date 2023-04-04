package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;

public interface UserService {
    User saveUser(UserRegistrationDto registrationDto);


}

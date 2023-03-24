package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.userdto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto registrationDto);

}

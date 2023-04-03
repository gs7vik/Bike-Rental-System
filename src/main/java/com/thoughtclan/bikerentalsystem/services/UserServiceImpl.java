package com.thoughtclan.bikerentalsystem.services;

import java.util.Arrays;


import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.UserRepository;
import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),registrationDto.getLicenseNo(),Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

}
package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.UserRegistrationDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.UserRepository;
import com.thoughtclan.bikerentalsystem.services.UserService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PatchMapper patchMapper;

    private final ModelMapper modelMapper;

    @Override
        public User saveUser(UserRegistrationDto registrationDto) {
            User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),registrationDto.getLicenseNo(),registrationDto.getContactNo(),Arrays.asList(new Role("USER")));
            return userRepository.save(user);
        }

    @Override

    public UserOutDto getUser(Long id) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return modelMapper.map(user1, UserOutDto.class);
    }
    @Override
    public UserOutDto partialUpdateUser(UserInDto input, Long id) {
        User users=modelMapper.map(input, User.class);
        User existingUser=userRepository.findById(id).orElseThrow(()->new RuntimeException("No user by such Id"));
        patchMapper.map(users,existingUser);
        existingUser=userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserOutDto.class);
    }

    @Override
    public UserOutDto updateUser(Long id, UserInDto input) {
        User users=modelMapper.map(input, User.class);
        User existingUser=userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No such user with that id"));
        modelMapper.map(users,existingUser);
        existingUser=userRepository.save(existingUser);
        return modelMapper.map(existingUser, UserOutDto.class);
    }


}
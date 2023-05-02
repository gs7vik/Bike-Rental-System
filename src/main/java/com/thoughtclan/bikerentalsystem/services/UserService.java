package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    LoginOutputDto login(LoginInputDto input);


    public UserOutputDto saveUser(UserInputDto user);


    public UserOutputDto getUser(Long id);


    UserOutDto partialUpdateUser(UserInDto input, Long id);

    UserOutDto updateUser(Long id, UserInDto input);

    //public LoginDto login(LoginInputDto input);

    UserOutputDto userMe();

    User getByFireBaseId(String uid);

    ResponseEntity<UserOutputDto> deleteUser(Long id);
}

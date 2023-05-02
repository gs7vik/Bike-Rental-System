package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.models.User;

public interface UserService {
    public UserOutputDto saveUser(UserInputDto user);


    public UserOutputDto getUser(Long id);

    public LoginOutputDto login(LoginInputDto input);

    User getByFireBaseId(String uid);

     UserOutputDto userMe();

}

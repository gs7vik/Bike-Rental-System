package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.LoginInputDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.LoginOutputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.UserOutputDto;
import com.thoughtclan.bikerentalsystem.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public UserOutputDto saveUser(UserInputDto user);


    public UserOutputDto getUser(Long id);

    public LoginOutputDto login(LoginInputDto input);

    User getByFireBaseId(String uid);

     UserOutputDto userMe();

    ResponseEntity<UserOutputDto> updateUser(Long id, UserInputDto input);

    List<BookingOutputDto> getUserBookings(Long id);

    ResponseEntity<UserOutputDto> deleteUser(Long roleId);

    List<UserOutputDto> getAllVendors(Long id);

    ResponseEntity<UserOutputDto> partialUpdate(Long id, UserInputDto input);
}

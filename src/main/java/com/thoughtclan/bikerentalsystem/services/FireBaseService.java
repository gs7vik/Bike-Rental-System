package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInDto;
import com.thoughtclan.bikerentalsystem.models.User;

public interface FireBaseService {
    public User createInFireBase(UserInDto userInput);
}

package com.thoughtclan.bikerentalsystem.services;


import com.google.firebase.auth.UserRecord;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInput;

public interface FireBaseService {
    public UserRecord createInFireBase(UserInput userInput);
}

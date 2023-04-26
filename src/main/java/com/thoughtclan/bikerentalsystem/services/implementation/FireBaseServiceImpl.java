package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.UserInput;
import com.thoughtclan.bikerentalsystem.services.FireBaseService;
import org.springframework.stereotype.Service;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;


@Service
public class FireBaseServiceImpl implements FireBaseService {
    @Override
    public UserRecord createInFireBase(UserInput input) {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(input.getEmail())
                .setPassword(input.getPassword())
                .setDisabled(false);
        try{
            return FirebaseAuth.getInstance().createUser(request);
        }
        catch(FirebaseAuthException exception){
            throw new RuntimeException(exception.getMessage());
        }


    }
}

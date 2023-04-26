package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Data;

@Data
public class SignInFireBaseOutput {

    public String idToken;
    public String email;
    public String refreshToken;
    public String expiresIn;
    public String localId;
    public boolean registered;

}

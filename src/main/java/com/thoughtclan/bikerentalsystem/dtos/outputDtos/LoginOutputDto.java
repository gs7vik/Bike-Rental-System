package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Data;

@Data
public class LoginOutputDto {
    private String accessToken;

    private String refreshToken;

    private String expiresIn;

    private String username;

}

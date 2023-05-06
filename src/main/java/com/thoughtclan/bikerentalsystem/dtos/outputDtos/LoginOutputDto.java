package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.models.User;
import lombok.Data;

@Data
public class LoginOutputDto {
    private String accessToken;

    private String refreshToken;

    private String expiresIn;

    private Long roleId;

    private String name;

    private String userName;

    private Long id;









}

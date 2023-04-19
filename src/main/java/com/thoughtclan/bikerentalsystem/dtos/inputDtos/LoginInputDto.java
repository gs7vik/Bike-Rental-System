package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;


@Data
public class LoginInputDto {
    private String username;
    private String password;
}

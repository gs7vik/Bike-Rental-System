package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;


@Data
public class LoginInputDto {
    private String email;
    private String password;
}

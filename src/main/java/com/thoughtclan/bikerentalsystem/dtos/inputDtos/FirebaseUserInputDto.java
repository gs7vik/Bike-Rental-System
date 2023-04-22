package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;


@Data
public class FirebaseUserInputDto {
    private String name;
    private String email;
    private String password;

}

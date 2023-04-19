package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class FirebaseUserInputDto {
    @NotBlank
    private String name;
    @Email
    private String email;
    private String password;

}

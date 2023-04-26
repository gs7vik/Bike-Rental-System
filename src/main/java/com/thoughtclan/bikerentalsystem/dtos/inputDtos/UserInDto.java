package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String licenseNo;
    private String contactNo;

}

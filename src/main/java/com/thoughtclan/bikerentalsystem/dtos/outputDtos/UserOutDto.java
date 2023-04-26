package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String licenseNo;
    private String contactNo;

}
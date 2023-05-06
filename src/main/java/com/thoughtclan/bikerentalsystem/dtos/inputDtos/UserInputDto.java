package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserInputDto {

    private Long id;

    private String firstName;


    private String lastName;


    private String email;



    private String password;



    private Date dob;


    private String licenseNo;


    private String contactNo;


    private Long roleId;
}

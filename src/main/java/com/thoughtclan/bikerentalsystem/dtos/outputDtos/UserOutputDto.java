package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {
    private Long id;


    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String contactNo;
    private String password;
    private String aadharNo;
    private String firebaseId;
    private String licenseNo;
    private Long roleId;
    private String roleName;
}

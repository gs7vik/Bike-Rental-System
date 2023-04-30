package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {
    private Long id;


    private String firstName;


    private String lastName;


    private String email;


    private String roleName;
}

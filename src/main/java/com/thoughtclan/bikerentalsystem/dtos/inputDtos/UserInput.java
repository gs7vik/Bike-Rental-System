package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    private String name;


    private String email;


    private String password;

}

package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;
@Data
public class HelpInputDto {
    private Long id;
    private String name;
    private UserInputDto user;
    private String email;
    private String description;
    private String contactNo;

}

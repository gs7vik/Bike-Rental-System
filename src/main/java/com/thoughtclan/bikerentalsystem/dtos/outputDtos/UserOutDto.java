package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutDto {
    private Integer id;
    private String name;
    private String description;
}
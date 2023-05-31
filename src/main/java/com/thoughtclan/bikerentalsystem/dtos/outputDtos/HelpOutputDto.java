package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.models.User;
import lombok.Data;

@Data
public class HelpOutputDto {
    private Long id;
    private User user;
    private String email;
    private String description;
}

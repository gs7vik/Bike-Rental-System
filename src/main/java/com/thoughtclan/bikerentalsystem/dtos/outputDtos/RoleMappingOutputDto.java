package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.models.ApiMapping;
import com.thoughtclan.bikerentalsystem.models.Role;
import lombok.Data;

@Data
public class RoleMappingOutputDto {
    private Long id;
    private Role role;
    private ApiMapping apiMapping;
}

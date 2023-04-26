package com.thoughtclan.bikerentalsystem.dtos.inputDtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInputDto {

    private Long id;
    private String name;
}
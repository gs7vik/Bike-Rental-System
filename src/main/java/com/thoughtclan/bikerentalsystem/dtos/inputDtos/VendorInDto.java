package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorInDto {
    private Long id;
    private String fullName;
    private String email;
    private String contactNo;
    private String address;
}

package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorOutDto {
    private Long id;
    private String fullName;
    private String contactNo;
    private String email;
    private String address;

}

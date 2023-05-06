package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import com.thoughtclan.bikerentalsystem.models.Vendor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BikeInDto {

    private Long id;
    private String brand;
    private String model;
    private String bikeNumberPlate;
    private byte[] image;
    private Double pricePerHour;
    private Long vendorId;
}

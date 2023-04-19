package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BikeInDto {

    private Long id;
    private String brand;
    private String model;
    private String bikeNumberPlate;

    private Double pricePerHour;
    private String isAvailable;
    private String imageUrl;
    private Long vendorId=1L;
}

package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.models.Vendor;
import lombok.Data;

@Data
public class BikeOutDto {
    private Integer id;
    private String brand;
    private String model;
    private String isAvailable;
    private Double pricePerHour;
    private String imageUrl;
    private VendorOutDto vendor;

}

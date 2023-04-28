package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.models.Vendor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collector;

@Data
public class BikeOutDto {
    private Long id;
    private String brand;
    private String model;
    private String bikeNumberPlate;
    private Double pricePerHour;
    private byte[] image;
    private Long vendorId;

}

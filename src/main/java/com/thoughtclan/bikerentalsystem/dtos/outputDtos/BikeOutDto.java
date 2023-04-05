package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Data;

@Data
public class BikeOutDto {
    private Integer id;
    private String Brand;
    private String model;
    private String is_available;
    private Double price_per_hour;
}

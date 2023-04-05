package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BikeInDto {
    private Long id;
    private String brand;
    private String model;
    private String bike_number;

    private Double price_per_hour;
    private String is_available;
}

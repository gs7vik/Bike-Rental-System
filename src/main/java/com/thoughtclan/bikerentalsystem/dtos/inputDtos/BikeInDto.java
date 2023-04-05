package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeInDto {
    private Long id;
    private String model;

    private String is_available;

    private Double price_per_hour;
}

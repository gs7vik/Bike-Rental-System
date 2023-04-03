package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeInDto {
    private Integer id;
    private String model;
    private Double price_per_hour;
    private String is_available;
}

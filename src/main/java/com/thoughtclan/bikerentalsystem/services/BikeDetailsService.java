package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;

import java.time.LocalDateTime;

public interface BikeDetailsService {

    Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime);
}

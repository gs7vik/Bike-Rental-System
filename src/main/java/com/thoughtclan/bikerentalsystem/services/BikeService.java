package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BikeService {

    Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime);

    BikeOutDto saveBike(BikeInDto input);

    BikeOutDto updatePrice(Long id, BikeInDto input);

    public List<BikeOutDto> getAllBikes();
}

package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.models.Bike;

import java.time.LocalDateTime;
import java.util.List;

public interface BikeService {

    public List<BikeOutDto> getBikesByVendor(Long id);

    Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime);

    Bike saveBike(BikeInDto input);

    BikeOutDto updatePrice(Long id, BikeInDto input);

    public List<BikeOutDto> getAllBikes();
}

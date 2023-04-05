package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;

public interface BikeService {
    public BikeOutDto saveBike(BikeInDto bikeDetails);

    BikeOutDto updatePrice(Long id, BikeInDto input);
}

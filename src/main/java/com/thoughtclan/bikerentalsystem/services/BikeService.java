package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.models.Bike;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BikeService {

    public List<BikeOutDto> getBikesByVendor(Long id);

    Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime);

//    Bike saveBike(BikeInDto input);

    BikeOutDto updatePrice(Long id, BikeInDto input);

    public BikeOutDto getBike(Long id);
    public List<BikeOutDto> getAllBikes();

    ResponseEntity<BikeOutDto> deleteBike(Long id);

//    ResponseEntity<BikeOutDto> updateBike(Long id,BikeInDto input);

    BikeOutDto addBike(BikeInDto bikeDetails);

    ResponseEntity<BikeOutDto> updateBike(Long id, BikeInDto bikeDetails);
}

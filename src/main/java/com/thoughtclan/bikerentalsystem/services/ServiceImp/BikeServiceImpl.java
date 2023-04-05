package com.thoughtclan.bikerentalsystem.services.ServiceImp;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.repositories.BikeRepository;
import com.thoughtclan.bikerentalsystem.services.BikeService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class BikeServiceImpl implements BikeService {
    private final ModelMapper modelMapper;

    private final BikeRepository bikeRepository;

    public BikeOutDto saveBike(BikeInDto bikeDetails) {
        Bike bikeData=modelMapper.map(bikeDetails, Bike.class);
        bikeData=bikeRepository.save(bikeData);
        return modelMapper.map(bikeData,BikeOutDto.class);

    }

    @Override
    public BikeOutDto updatePrice(Long id,BikeInDto input) {
        Bike b_price=modelMapper.map(input,Bike.class);
        Bike existing_bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        modelMapper.map(b_price,existing_bike);
        existing_bike=bikeRepository.save(existing_bike);
        return modelMapper.map(existing_bike,BikeOutDto.class);
    }
}

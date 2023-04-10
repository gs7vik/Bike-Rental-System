package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.repositories.BikeRepository;
import com.thoughtclan.bikerentalsystem.services.BikeService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final ModelMapper modelMapper;

    private final PatchMapper patchMapper;
    private final BikeRepository bikeRepository;
    public Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime){

        long hoursBetween = ChronoUnit.HOURS.between(fromTime, toTime);
        long minutesBetween = ChronoUnit.MINUTES.between(fromTime,toTime)-(hoursBetween*60);
        double estPrice = (hoursBetween*pricePerHour)+(minutesBetween*(pricePerHour/(60)));
        return estPrice;
    }

    public BikeOutDto saveBike(BikeInDto bikeDetails) {
        Bike bikeData=modelMapper.map(bikeDetails, Bike.class);
        bikeData=bikeRepository.save(bikeData);
        return modelMapper.map(bikeData,BikeOutDto.class);

    }


    public BikeOutDto updatePrice(Long id,BikeInDto input) {
        Bike b_price=modelMapper.map(input,Bike.class);
        Bike existing_bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        patchMapper.map(b_price,existing_bike);
        existing_bike=bikeRepository.save(existing_bike);
        return modelMapper.map(existing_bike,BikeOutDto.class);
    }

    @Override
    public BikeOutDto deleteBike() {
        return null;
    }


    public List<BikeOutDto> myBikes() {
        List<Bike> users = bikeRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user,BikeOutDto.class)).collect(Collectors.toList());

    }

    public ResponseEntity<BikeOutDto> deleteBike(Long id) {
        Bike bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        bikeRepository.delete(bike);
        return ResponseEntity.ok(modelMapper.map(bike,BikeOutDto.class));

    }

}

package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.models.Vendor;
import com.thoughtclan.bikerentalsystem.repositories.BikeRepository;
import com.thoughtclan.bikerentalsystem.repositories.VendorRepository;
import com.thoughtclan.bikerentalsystem.services.BikeService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final VendorRepository vendorRepository;

    @Override
    public List<BikeOutDto> getBikesByVendor(Long id) {
        List<Bike> vendorBikes=bikeRepository.findByVendorId(id);
        return vendorBikes.stream().map(vendorBike1->modelMapper.map(vendorBike1,BikeOutDto.class)).collect(Collectors.toList());

    }

    public Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime){

        long hoursBetween = ChronoUnit.HOURS.between(fromTime, toTime);
        long minutesBetween = ChronoUnit.MINUTES.between(fromTime,toTime)-(hoursBetween*60);
        double estPrice = (hoursBetween*pricePerHour)+(minutesBetween*(pricePerHour/(60)));
        return estPrice;
    }

    public Bike saveBike(BikeInDto bikeDetails) {
        Bike bikeData=modelMapper.map(bikeDetails, Bike.class);
        Vendor vendor = vendorRepository.findById(bikeDetails.getVendorId()).orElseThrow(()->new RuntimeException());
        bikeData.setVendor(vendor);
        bikeData=bikeRepository.save(bikeData);
        return modelMapper.map(bikeData,Bike.class);

    }


    public BikeOutDto updatePrice(Long id,BikeInDto input) {
        Bike b_price=modelMapper.map(input,Bike.class);
        Bike existing_bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        patchMapper.map(b_price,existing_bike);
        existing_bike=bikeRepository.save(existing_bike);
        return modelMapper.map(existing_bike,BikeOutDto.class);
    }


    @Override
    public BikeOutDto getBike(Long id){
        Bike bike=bikeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Bike with "+id+"is not found"));
        return modelMapper.map(bike,BikeOutDto.class);
    }

    @Override
    public List<BikeOutDto> getAllBikes(){
        List<Bike> bikes=bikeRepository.findAll();
        return bikes.stream().map(orders->modelMapper.map(orders,BikeOutDto.class)).collect(Collectors.toList());
    }

}

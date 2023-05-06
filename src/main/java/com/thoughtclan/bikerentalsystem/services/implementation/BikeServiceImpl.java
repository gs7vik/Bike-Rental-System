package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.enums.BikeStatus;
import com.thoughtclan.bikerentalsystem.enums.BookingStatus;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.models.Booking;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.models.Vendor;
import com.thoughtclan.bikerentalsystem.repositories.BikeRepository;
import com.thoughtclan.bikerentalsystem.repositories.BookingRepository;
import com.thoughtclan.bikerentalsystem.repositories.UserRepository;
import com.thoughtclan.bikerentalsystem.repositories.VendorRepository;
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
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;

    private final BookingRepository bookingRepository;


    //Get the bikes added by a particular Vendor
    public List<BikeOutDto> getBikesByVendor(Long id) {
        List<Bike> vendorBikes=bikeRepository.findByVendorIdId(id);
        List<BikeOutDto> bikes;
        bikes= vendorBikes.stream().map(vendorBike1->modelMapper.map(vendorBike1,BikeOutDto.class)).collect(Collectors.toList());
        return bikes;

    }

    public Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime){

        long hoursBetween = ChronoUnit.HOURS.between(fromTime, toTime);

        long minutesBetween = ChronoUnit.MINUTES.between(fromTime,toTime)-(hoursBetween*60);
        double estPrice = (hoursBetween*pricePerHour)+(minutesBetween*(pricePerHour/(60)));
        return estPrice;
    }


//    public Bike saveBike(BikeInDto bikeDetails) {
//        Bike bikeData=modelMapper.map(bikeDetails, Bike.class);
//        Vendor vendor = vendorRepository.findById(bikeDetails.getVendorId()).orElseThrow(()->new RuntimeException());
//        bikeData.setVendorId(vendor);
//        bikeData=bikeRepository.save(bikeData);
//        return modelMapper.map(bikeData,Bike.class);
//
//    }

    //Add a new bike to Database
    public BikeOutDto addBike(BikeInDto bikeDetails) {
        Bike bikenotes=modelMapper.map(bikeDetails, Bike.class);
        User user=userRepository.findById(bikeDetails.getVendorId()).orElseThrow(()->new RuntimeException());
        bikenotes.setVendorId(user);
        bikeRepository.save(bikenotes);
        return modelMapper.map(bikenotes, BikeOutDto.class);
    }


    //update the already existing bike
    @Override
    public ResponseEntity<BikeOutDto> updateBike(Long id, BikeInDto bikeDetails) {
        Bike bike=modelMapper.map(bikeDetails,Bike.class);
        Bike existing_bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such Id"));
        modelMapper.map(bike,existing_bike);
        existing_bike=bikeRepository.save(existing_bike);
        return ResponseEntity.ok(modelMapper.map(existing_bike, BikeOutDto.class));

    }

    @Override
    public List<BikeOutDto> getByStatus(String bikeStatus) {
        BikeStatus status=BikeStatus.valueOf(bikeStatus);

        List<Bike> bikes=  bikeRepository.findByBikeStatus(status);
        return bikes.stream().map(orders->modelMapper.map(orders,BikeOutDto.class)).collect(Collectors.toList());
    }
    public void updateBikeStatus(Long bikeId){
        Bike bike=bikeRepository.findById(bikeId).orElseThrow(()->new EntityNotFoundException("No bike found"));
        List<Booking> bookings=bookingRepository.findByIdAndBookingStatus(bikeId, BookingStatus.BOOKED);
        if(!bookings.isEmpty()) {
            bike.setBikeStatus(BikeStatus.UNDER_BOOKING);
        }
        bikeRepository.save(bike);
    }


    //partial updating of bike
    public BikeOutDto updatePrice(Long id,BikeInDto input) {
        Bike b_price=modelMapper.map(input,Bike.class);
        Bike existing_bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        patchMapper.map(b_price,existing_bike);
        existing_bike=bikeRepository.save(existing_bike);
        return modelMapper.map(existing_bike,BikeOutDto.class);
    }

    //get details of a particular bike
    @Override
    public BikeOutDto getBike(Long id){
        Bike bike=bikeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Bike with "+id+"is not found"));
        return modelMapper.map(bike,BikeOutDto.class);
    }

    //Get all bikes present in Database
    @Override
    public List<BikeOutDto> getAllBikes(){
        List<Bike> bikes=bikeRepository.findAll();
        return bikes.stream().map(orders->modelMapper.map(orders,BikeOutDto.class)).collect(Collectors.toList());
    }


    //delete a particular bike using Id
    @Override
    public ResponseEntity<BikeOutDto> deleteBike(Long id) {
        Bike bike=bikeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No bike with such id"));
        bikeRepository.delete(bike);
        return ResponseEntity.ok(modelMapper.map(bike, BikeOutDto.class));
    }


//    @Override
//    public ResponseEntity<BikeOutDto> updateBike(Long id,BikeInDto input) {
//        Bike bike=modelMapper.map(input, Bike.class);
//        Bike existingBike=bikeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("not bike with such Id"));
//        modelMapper.map(bike,existingBike);
//        existingBike=bikeRepository.save(existingBike);
//        return ResponseEntity.ok(modelMapper.map(existingBike, BikeOutDto.class));
//    }


    public List<Bike> getAllAvailableVehicles(List<Bike>bikes,LocalDateTime fromTime,LocalDateTime toTime){
        List<Booking> bookings=bookingRepository.findAll();
        boolean cond=true;
        Booking booking=null;
        for(int i=0;i<bookings.size();i++){
            booking=bookings.get(i);
            LocalDateTime ftime=booking.getStartTime();
            LocalDateTime ttime=booking.getEndTime();

            if(ftime.equals(fromTime) || ftime.equals(toTime)){
                cond=false;
            }
            else if(ttime.equals(fromTime) || ttime.equals(toTime)){
                cond=false;
            }
            else if(fromTime.isAfter(ftime) && toTime.isBefore(ftime)){
                cond = false;
            }
            else if(fromTime.isAfter(ttime) && toTime.isBefore(ttime)){
                cond = false;
            }

            if(!cond){
                Bike bike1 = booking.getBike();
                bookings.remove(bike1);
            }

        }
            return  bikes;
    }



}

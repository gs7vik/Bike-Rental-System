package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.models.BikeDetails;
import com.thoughtclan.bikerentalsystem.models.Booking;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.*;
import com.thoughtclan.bikerentalsystem.services.BikeDetailsService;
import com.thoughtclan.bikerentalsystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private final BikeDetailsRepository bikeDetailsRepository;

    private final BookingRepository bookingRepository;

   private final PrivilegesRepository privilegesRepository;

    private final UserRepository userRepository;

    private final BikeDetailsService bikeDetailsService;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;
    @Override
    public BookingOutputDto saveBooking(BookingInputDto bookingInputDto) {
            Booking booking=modelMapper.map(bookingInputDto, Booking.class);

            User user=userRepository.findById(bookingInputDto.getUser().getId()).orElse(null);
            booking.setUser(user);
          /* BikeDetails bikeDetails=bikeDetailsRepository.findById(booking.getId()).orElse(null);
           booking.setBikeDetails(bikeDetails);*/

          /*
            Double price=bikeDetailsService.calculatePrice(bikeDetails.getPrice_per_hour(),booking.getStartTime(),booking.getEndTime());
            booking.setTotalPrice(price);

           */
            booking.setTotalPrice(100.00);
            bookingRepository.save(booking);
            this.modelMapper.map(booking, BookingOutputDto.class);
        BookingOutputDto fnvlrnvlnb = modelMapper.map(booking, BookingOutputDto.class);
            return fnvlrnvlnb;
    }




}

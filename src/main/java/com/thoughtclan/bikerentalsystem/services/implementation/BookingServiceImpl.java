package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.models.Booking;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.*;
import com.thoughtclan.bikerentalsystem.services.BikeService;
import com.thoughtclan.bikerentalsystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {


    private final BikeRepository bikeRepository;

    private final BookingRepository bookingRepository;

   private final PrivilegesRepository privilegesRepository;

    private final UserRepository userRepository;

    private final BikeService bikeService;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;
    @Override
    public BookingOutputDto saveBooking(BookingInputDto bookingInputDto) {
            Booking booking=modelMapper.map(bookingInputDto, Booking.class);

            User user=userRepository.findById(bookingInputDto.getUser().getId()).orElse(null);
            booking.setUser(user);

          Bike bike = bikeRepository.findById(bookingInputDto.getBike().getId()).orElse(null);
           booking.setBike(bike);


            Double price= bikeService.calculatePrice(bike.getPricePerHour(),booking.getStartTime(),booking.getEndTime());
            booking.setTotalPrice(price);
            bikeService.updateBikeStatus(booking.getBike().getId());


            bookingRepository.save(booking);
            this.modelMapper.map(booking, BookingOutputDto.class);
        BookingOutputDto fnvlrnvlnb = modelMapper.map(booking, BookingOutputDto.class);
            return fnvlrnvlnb;
    }

    @Override
    public BookingOutputDto getBooking(Long id){
        Booking booking=bookingRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Booking with "+id+"is not found"));
        return modelMapper.map(booking,BookingOutputDto.class);
    }

    @Override
    public List<BookingOutputDto> getAllBookings(){
        List<Booking> booking=bookingRepository.findAll();
        return booking.stream().map(orders->modelMapper.map(orders,BookingOutputDto.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<BookingOutputDto>deleteBooking(Long id){
                Booking booking=bookingRepository.findById(id).orElseThrow(()->new EntityNotFoundException("booking with given id not found"));
                bookingRepository.delete(booking);
                return ResponseEntity.ok(modelMapper.map(booking,BookingOutputDto.class));
    }


    /*
    public List<BookingOutputDto> getBookingByStatus(BookingStatus bookingStatus){
        List<Booking> booking = bookingRepository.findByBookingStatus(bookingStatus);
        return booking.stream().map(order->modelMapper.map(order,BookingOutputDto.class)).collect(Collectors.toList());
    }


     */


}

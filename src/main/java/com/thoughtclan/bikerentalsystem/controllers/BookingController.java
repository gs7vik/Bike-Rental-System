package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.services.implementation.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor

@CrossOrigin
public class BookingController {

    private final BookingServiceImpl bookingService;



    @PostMapping
    public BookingOutputDto createBooking(@RequestBody BookingInputDto input){
        return bookingService.saveBooking(input);
    }


    @GetMapping("/{id}")
    public BookingOutputDto getBookingById(@PathVariable Long id){
        return bookingService.getBooking(id);
    }


    @GetMapping
    public List<BookingOutputDto> getAllBookings(){return bookingService.getAllBookings();}

    /*
    @GetMapping("/getBookingByStatus")
    public List<BookingOutputDto> getBookingByStatus(@RequestParam(name = "bookingStatus") BookingStatus bookingStatus){
        return bookingService.getBookingByStatus(bookingStatus);

    }
    */



    @DeleteMapping("/{id}")
    public ResponseEntity<BookingOutputDto>deleteBookingById(@PathVariable Long id){return bookingService.deleteBooking(id);}

}

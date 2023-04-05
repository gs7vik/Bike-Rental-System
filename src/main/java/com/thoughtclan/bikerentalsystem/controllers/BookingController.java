package com.thoughtclan.bikerentalsystem.controllers;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.services.implementation.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
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




}

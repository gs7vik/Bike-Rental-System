package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BookingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.models.Booking;
import org.modelmapper.ModelMapper;

public interface BookingService {

    public BookingOutputDto saveBooking(BookingInputDto bookingInputDto);

    public BookingOutputDto getBooking(Long id);
}

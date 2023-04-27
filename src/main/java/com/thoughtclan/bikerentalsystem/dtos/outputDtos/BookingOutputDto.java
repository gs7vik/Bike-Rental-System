package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.enums.BookingStatus;
import com.thoughtclan.bikerentalsystem.models.Bike;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingOutputDto {
    private Long id;


    private LocalDateTime startTime;


    private LocalDateTime endTime;

    private Double price;

   // private User user;

    private Bike bike;

    private BookingStatus status;




}

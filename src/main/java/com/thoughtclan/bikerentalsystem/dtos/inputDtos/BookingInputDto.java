package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingInputDto {

    private Long id;


    private LocalDateTime startTime;


    private LocalDateTime endTime;

    private BikeInDto bike;
    private UserInDto user;




}

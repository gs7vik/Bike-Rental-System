package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import com.thoughtclan.bikerentalsystem.models.BikeDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class BookingInputDto {

    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    //private BikeInDto bike;
    private UserInDto user;




}

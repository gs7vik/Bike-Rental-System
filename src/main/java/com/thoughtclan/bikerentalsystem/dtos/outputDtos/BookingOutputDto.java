package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingOutputDto {
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double price;


}

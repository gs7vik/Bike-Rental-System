package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtclan.bikerentalsystem.enums.BookingStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class BookingInputDto {

    private Long id;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;
    private UserInDto user;

    private BikeInDto bike;
    private BookingStatus status;






}

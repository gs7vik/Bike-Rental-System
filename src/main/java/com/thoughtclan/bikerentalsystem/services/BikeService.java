package com.thoughtclan.bikerentalsystem.services;

import java.time.LocalDateTime;

public interface BikeService {

    Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime);
}

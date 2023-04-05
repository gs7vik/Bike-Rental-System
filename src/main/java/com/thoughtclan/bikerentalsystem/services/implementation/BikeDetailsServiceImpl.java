package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.services.BikeDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class BikeDetailsServiceImpl implements BikeDetailsService {
    public Double calculatePrice (Double pricePerHour, LocalDateTime fromTime, LocalDateTime toTime){
        //2018-02-05T10:55:11
        long hoursBetween = ChronoUnit.HOURS.between(fromTime, toTime);
        long minutesBetween = ChronoUnit.MINUTES.between(fromTime,toTime)-(hoursBetween*60);
        double estPrice = (hoursBetween*pricePerHour)+(minutesBetween*(pricePerHour/(60)));
        return estPrice;
    }

}

package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BookingOutputDto;
import com.thoughtclan.bikerentalsystem.services.BikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
@Slf4j
@CrossOrigin
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping("/addBike")
    public BikeOutDto addBike(@RequestBody BikeInDto input){
        return bikeService.saveBike(input);
    }

    @PatchMapping("/{id}")
    public BikeOutDto updateBike(@PathVariable Long id,@RequestBody BikeInDto input){
        return bikeService.updatePrice(id,input);
    }

    @GetMapping
    public List<BikeOutDto> getAllBike(){return bikeService.getAllBikes();}




}

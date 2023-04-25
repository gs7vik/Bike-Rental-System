package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.models.Bike;
import com.thoughtclan.bikerentalsystem.services.BikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Bike addBike(@RequestBody BikeInDto input){
        return bikeService.saveBike(input);
    }

    @PatchMapping("/update/{id}")
    public BikeOutDto updateBike(@PathVariable Long id,@RequestBody BikeInDto input){
        return bikeService.updatePrice(id,input);
    }
    @GetMapping("/vendor/{id}")
    public List<BikeOutDto> getVendorBikes(@PathVariable Long id){
        return bikeService.getBikesByVendor(id);
    }
    @GetMapping("/{id}")
    public BikeOutDto getBikeById(@PathVariable Long id){
        return bikeService.getBike(id);
    }

    @GetMapping
    public List<BikeOutDto> getAllBike(){return bikeService.getAllBikes();}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BikeOutDto> deleteBike(@PathVariable Long id){
        return bikeService.deleteBike(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BikeOutDto> updateBike(@PathVariable long id,@RequestBody BikeInDto input){
        return bikeService.updateBike(id,input);
    }

}



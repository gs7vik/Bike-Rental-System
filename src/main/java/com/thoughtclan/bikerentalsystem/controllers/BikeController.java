package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.BikeInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
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

    @GetMapping("/bikes/{id}")
    public List<BikeOutDto> myBikes(){return bikeService.myBikes();}

    @PatchMapping("/{id}")
    public BikeOutDto updateBike(@PathVariable Long id,@RequestBody BikeInDto input){
        return bikeService.updatePrice(id,input);
    }
    @DeleteMapping("/{id}")
    public BikeOutDto deleteBike(@PathVariable Long id){
        return null;
    }

}

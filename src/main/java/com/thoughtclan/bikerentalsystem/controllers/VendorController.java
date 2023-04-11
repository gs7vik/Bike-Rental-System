package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import com.thoughtclan.bikerentalsystem.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/vendor")
@RequiredArgsConstructor

public class VendorController {
    public VendorService vendorService;

    @PostMapping("/addVendor")
    public VendorOutDto addvendor(@RequestBody VendorInDto vendor){
        return vendorService.addvendor(vendor);
    }
}

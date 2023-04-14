package com.thoughtclan.bikerentalsystem.controllers;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import com.thoughtclan.bikerentalsystem.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor

public class VendorController {
    private final VendorService vendorService;

    @PostMapping("/addVendor")
    public VendorOutDto saveVendor(@RequestBody VendorInDto input){
        return vendorService.addVendor(input);
    }
    @GetMapping()
    public String gummy(){
        return "dummy";
    }
}

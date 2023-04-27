package com.thoughtclan.bikerentalsystem.controllers;
import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import com.thoughtclan.bikerentalsystem.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
@CrossOrigin
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    public VendorOutDto saveVendor(@RequestBody VendorInDto input){
        return vendorService.addVendor(input);
    }
    @GetMapping("{id}")
    public VendorOutDto getVendor(@PathVariable Long id){
        return vendorService.getVendor(id);
    }

    @PatchMapping("/partialupdate/{id}")
    public VendorOutDto partialUpdateVendor(@RequestBody VendorInDto input,@PathVariable Long id){
        return vendorService.partialUpdateVendor(input,id);
    }
    @PutMapping("/update/{id}")
    public VendorOutDto updateVendor(@RequestBody VendorInDto input,@PathVariable Long id){
        return vendorService.updateVendor(id,input);
    }

}

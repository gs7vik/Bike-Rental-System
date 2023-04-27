package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.BikeOutDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import org.springframework.http.ResponseEntity;

public interface VendorService {
    VendorOutDto addVendor(VendorInDto vendor);

    VendorOutDto getVendor(Long id);

    VendorOutDto partialUpdateVendor(VendorInDto input, Long id);

    VendorOutDto updateVendor(Long id, VendorInDto input);
}

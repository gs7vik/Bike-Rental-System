package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;

public interface VendorService {
    VendorOutDto addvendor(VendorInDto vendor);
}

package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import com.thoughtclan.bikerentalsystem.models.Vendor;
import com.thoughtclan.bikerentalsystem.repositories.VendorRespository;
import com.thoughtclan.bikerentalsystem.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
    private final VendorRespository vendorRespository;

    private final ModelMapper modelMapper;
    @Override
    public VendorOutDto addVendor(VendorInDto vendor) {
        Vendor vendor1=modelMapper.map(vendor,Vendor.class);
        vendor1= vendorRespository.save(vendor1);
        return modelMapper.map(vendor1,VendorOutDto.class);
    }
}

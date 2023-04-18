package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.VendorInDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.VendorOutDto;
import com.thoughtclan.bikerentalsystem.exception.EntityNotFoundException;
import com.thoughtclan.bikerentalsystem.models.Vendor;
import com.thoughtclan.bikerentalsystem.repositories.VendorRepository;
import com.thoughtclan.bikerentalsystem.services.VendorService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;

    private final ModelMapper modelMapper;

    private final PatchMapper patchMapper;

    //adds vendor to database
    @Override
    public VendorOutDto addVendor(VendorInDto vendor) {
        Vendor vendor1=modelMapper.map(vendor,Vendor.class);

        vendor1= vendorRepository.save(vendor1);
        return modelMapper.map(vendor1,VendorOutDto.class);
    }

    @Override
    public VendorOutDto getVendor(Long id) {
        Vendor vendor=vendorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No Vendor with "+id));
        return modelMapper.map(vendor,VendorOutDto.class);
    }

    @Override
    public VendorOutDto partialUpdateVendor(VendorInDto input, Long id) {
        Vendor vendor=modelMapper.map(input, Vendor.class);
        Vendor existingVendor=vendorRepository.findById(id).orElseThrow(()->new RuntimeException("No vendor by such Id"));
        patchMapper.map(vendor,existingVendor);
        existingVendor=vendorRepository.save(existingVendor);
        return modelMapper.map(existingVendor, VendorOutDto.class);
    }

    @Override
    public VendorOutDto updateVendor(Long id, VendorInDto input) {
        Vendor vendor=modelMapper.map(input, Vendor.class);
        Vendor existingVendor=vendorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No such vendor with that id"));
        modelMapper.map(vendor,existingVendor);
        existingVendor=vendorRepository.save(existingVendor);
        return modelMapper.map(existingVendor, VendorOutDto.class);
    }
}

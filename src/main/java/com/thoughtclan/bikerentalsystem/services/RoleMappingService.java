package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleMappingOutputDto;

import java.util.List;

public interface RoleMappingService {
    public RoleMappingOutputDto createRoleMapping(RoleMappingInputDto input);

    public List<Long> getRoles(Long id);

}
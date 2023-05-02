package com.thoughtclan.bikerentalsystem.services.implementation;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleMappingOutputDto;
import com.thoughtclan.bikerentalsystem.models.ApiMapping;
import com.thoughtclan.bikerentalsystem.models.Role;
import com.thoughtclan.bikerentalsystem.models.RoleMapping;
import com.thoughtclan.bikerentalsystem.repositories.ApiMappingRepository;
import com.thoughtclan.bikerentalsystem.repositories.RoleMappingRepository;
import com.thoughtclan.bikerentalsystem.repositories.RoleRepository;
import com.thoughtclan.bikerentalsystem.services.RoleMappingService;
import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleMappingServiceImpl implements RoleMappingService {
    private final RoleMappingRepository roleMappingRepository;

    private final RoleRepository roleRepository;

    private final ApiMappingRepository apiMappingRepository;

    private final ModelMapper modelMapper;

    private final PatchMapper patchMapper;

    @Override
    public RoleMappingOutputDto createRoleMapping(RoleMappingInputDto input) {
        RoleMapping roleMapping = new RoleMapping();
        Role role = roleRepository.findById(input.getRoleId()).orElseThrow(()->new RuntimeException());
        ApiMapping apiMapping = apiMappingRepository.findById(input.getApiId()).orElseThrow(()->new RuntimeException());
        roleMapping.setRole(role);
        roleMapping.setApiMapping(apiMapping);
        roleMapping = roleMappingRepository.save(roleMapping);
        return modelMapper.map(roleMapping,RoleMappingOutputDto.class);
    }
    public List<Long> getRoles(Long id){
        List<RoleMapping> roleMappings = roleMappingRepository.findByApiMappingId(id);
        List<Long> roleIds = new ArrayList<>();
        for(RoleMapping roleMapping : roleMappings){
            roleIds.add(roleMapping.getRole().getId());
        }
        return roleIds;
    }
}

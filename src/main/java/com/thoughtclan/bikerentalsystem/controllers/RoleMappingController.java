package com.thoughtclan.bikerentalsystem.controllers;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.RoleMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.RoleMappingOutputDto;
import com.thoughtclan.bikerentalsystem.repositories.RoleMappingRepository;
import com.thoughtclan.bikerentalsystem.services.RoleMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleMapping")
@RequiredArgsConstructor
public class RoleMappingController {
    private final RoleMappingService roleMappingService;

    private final RoleMappingRepository roleMappingRepository;

    @PostMapping()
    public RoleMappingOutputDto roleMappingOutputDto(@RequestBody RoleMappingInputDto input){
        return roleMappingService.createRoleMapping(input);
    }

    @GetMapping("/{id}")
    public List<Long> getRoles(@PathVariable Long id){
        return roleMappingService.getRoles(id);
    }

}

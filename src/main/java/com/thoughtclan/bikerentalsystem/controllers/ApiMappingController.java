package com.thoughtclan.bikerentalsystem.controllers;


import com.thoughtclan.bikerentalsystem.dtos.inputDtos.ApiMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.ApiMappingOutputDto;
import com.thoughtclan.bikerentalsystem.services.ApiMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiMapping")
@RequiredArgsConstructor
public class ApiMappingController {

    private final ApiMappingService apiMappingService;

    @PostMapping()
    public ApiMappingOutputDto createApiMapping(@RequestBody ApiMappingInputDto input){
        return apiMappingService.createApiMapping(input);
    }

    @GetMapping("/{id}")
    public ApiMappingOutputDto getById(@PathVariable Long id){
        return apiMappingService.getApiMapping(id);
    }

    @PatchMapping("/{id}")
    public ApiMappingOutputDto patch(@PathVariable Long id, @RequestBody ApiMappingInputDto input){
        return apiMappingService.partialUpdate(id,input);
    }

    @GetMapping()
    public ApiMappingOutputDto getAllPermissions(@RequestBody ApiMappingInputDto input){
        return apiMappingService.getAllPermissions(input.getHttpMethod(),input.getUrl());
    }

    @DeleteMapping("/{id}")
    public String deleteApi(@PathVariable Long id){
        return apiMappingService.deleteApi(id);
    }

}

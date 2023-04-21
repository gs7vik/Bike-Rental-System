package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.ApiMappingInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.ApiMappingOutputDto;
import org.springframework.http.HttpMethod;

public interface ApiMappingService {
    public ApiMappingOutputDto createApiMapping(ApiMappingInputDto input);
    public ApiMappingOutputDto getApiMapping(Long id);

    public ApiMappingOutputDto partialUpdate(Long id, ApiMappingInputDto input);

    public ApiMappingOutputDto getAllPermissions(HttpMethod httpMethod, String url);

    public String deleteApi(Long id);
}

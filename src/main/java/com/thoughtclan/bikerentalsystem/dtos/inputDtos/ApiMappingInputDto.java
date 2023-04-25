package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import lombok.Data;
import org.springframework.http.HttpMethod;

@Data
public class ApiMappingInputDto {
    private String url;
    private HttpMethod httpMethod;
}

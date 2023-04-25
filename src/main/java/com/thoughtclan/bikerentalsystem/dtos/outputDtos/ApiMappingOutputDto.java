package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import lombok.Data;
import org.springframework.http.HttpMethod;

@Data
public class ApiMappingOutputDto {
    private Long id;
    private String url;
    private HttpMethod httpMethod;
}

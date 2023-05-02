package com.thoughtclan.bikerentalsystem.dtos.outputDtos;

import com.thoughtclan.bikerentalsystem.utils.HttpMethod;
import lombok.Data;


@Data
public class ApiMappingOutputDto {
    private Long id;
    private String url;
    private HttpMethod httpMethod;
}

package com.thoughtclan.bikerentalsystem.dtos.inputDtos;

import com.thoughtclan.bikerentalsystem.utils.HttpMethod;
import lombok.Data;


@Data
public class ApiMappingInputDto {
    private String url;
    private HttpMethod httpMethod;
}

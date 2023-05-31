package com.thoughtclan.bikerentalsystem.services;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.HelpInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.HelpOutputDto;

public interface HelpService {
    HelpOutputDto addMessage(HelpInputDto input);
}

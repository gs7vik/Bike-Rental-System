package com.thoughtclan.bikerentalsystem.controllers;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.HelpInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.HelpOutputDto;
import com.thoughtclan.bikerentalsystem.services.HelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/help")
@RequiredArgsConstructor
@CrossOrigin
public class HelpController {

    private final HelpService helpService;

    @PostMapping("/newEntry")
    public HelpOutputDto newMessage(@RequestBody HelpInputDto input){
        return helpService.addMessage(input);
    }
}

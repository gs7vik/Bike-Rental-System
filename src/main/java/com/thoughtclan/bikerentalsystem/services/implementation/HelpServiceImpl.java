package com.thoughtclan.bikerentalsystem.services.implementation;

import com.thoughtclan.bikerentalsystem.dtos.inputDtos.HelpInputDto;
import com.thoughtclan.bikerentalsystem.dtos.outputDtos.HelpOutputDto;
import com.thoughtclan.bikerentalsystem.models.Help;
import com.thoughtclan.bikerentalsystem.models.User;
import com.thoughtclan.bikerentalsystem.repositories.HelpRepository;
import com.thoughtclan.bikerentalsystem.repositories.UserRepository;
import com.thoughtclan.bikerentalsystem.services.HelpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class HelpServiceImpl implements HelpService {

    private final HelpRepository helpRepository;
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;
    @Override
    public HelpOutputDto addMessage(HelpInputDto input) {
        Help help=modelMapper.map(input, Help.class);
        User user=userRepository.findById(input.getUser().getId()).orElse(null);
        help.setUser(user);
        help.setWrittenOn(LocalDateTime.now());
        helpRepository.save(help);
        return modelMapper.map(help, HelpOutputDto.class);
    }
}

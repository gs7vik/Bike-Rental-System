package com.thoughtclan.bikerentalsystem;

import com.thoughtclan.bikerentalsystem.utils.PatchMapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BikeRentalSystemApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PatchMapper patchMapper(){
        PatchMapper patchMapper = new PatchMapper();
        patchMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setPropertyCondition(Conditions.isNotNull());
        return patchMapper;

    }
    public static void main(String[] args) {SpringApplication.run(BikeRentalSystemApplication.class, args);
    }

}

package com.thoughtclan.bikerentalsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BikeRentalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeRentalSystemApplication.class, args);
    }

}

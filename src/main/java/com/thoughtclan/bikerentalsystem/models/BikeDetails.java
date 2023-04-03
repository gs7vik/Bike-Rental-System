package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BikeDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String model;

    @Column(nullable = false)
    private String bike_number;

    private Double price_per_hour;

    @Column(nullable = false)
    private String is_available;

}

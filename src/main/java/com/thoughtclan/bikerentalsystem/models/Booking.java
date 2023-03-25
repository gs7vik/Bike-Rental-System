package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne( targetEntity = BikeDetails.class )
    private BikeDetails bikeDetails;
    private Date in_time;

    private Date out_time;

    private Double price;



}

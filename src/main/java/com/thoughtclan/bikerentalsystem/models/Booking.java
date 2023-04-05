package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   /* @ManyToOne( targetEntity = BikeDetails.class )

    private BikeDetails bikeDetails;

    */

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;


}

package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne( targetEntity = Bike.class )

    private Bike bike;


    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;


}

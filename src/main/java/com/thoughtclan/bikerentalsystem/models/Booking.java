package com.thoughtclan.bikerentalsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thoughtclan.bikerentalsystem.enums.BikeStatus;
import com.thoughtclan.bikerentalsystem.enums.BookingStatus;
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

    @JsonFormat(pattern="dd-MM-yyyy 'T' HH:mm")
    private LocalDateTime startTime;

    @JsonFormat(pattern="dd-MM-yyyy 'T' HH:mm")
    private LocalDateTime endTime;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus bookingStatus=BookingStatus.BOOKED;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;


}

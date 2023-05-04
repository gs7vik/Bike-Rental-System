package com.thoughtclan.bikerentalsystem.models;

import com.thoughtclan.bikerentalsystem.enums.BikeStatus;
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

@Table(name="bike", uniqueConstraints = @UniqueConstraint(columnNames ={ "bike_number_plate"}))
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name="bike_number_plate")
    private String bikeNumberPlate;

    @Column(name = "Price_per_hour")
    private Double pricePerHour;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BikeStatus bikeStatus=BikeStatus.AVAILABLE;

    @Lob
    @Column(name = "image")
    private byte[] image;

//    @ManyToOne
//    @JoinColumn(name="vendorId",referencedColumnName = "id")
//    private Vendor vendorId;

    @ManyToOne
    @JoinColumn(name="vendorId",referencedColumnName = "id")
    private User userId;


//test
}

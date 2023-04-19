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

public class Bike {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(nullable = false)
    private String bikeNumberPlate;

    @Column(name = "Price_per_hour")
    private Double pricePerHour;

    @Column(name="image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="vendorId",referencedColumnName = "id")
    private Vendor vendor;


//test
}

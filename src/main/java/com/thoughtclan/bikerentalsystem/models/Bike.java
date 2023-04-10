package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String bike_number;

    @Column(name = "Price_per_hour")
    private Double price_per_hour;

    @Column(nullable = false)
    private String is_available;

    @Column (name="bikeImage_url")
    private String bikeImage_url;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="vehicle_privileges_mapping",joinColumns=@JoinColumn(name="bike_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="privileges_id",referencedColumnName="id"))
    private List<com.thoughtclan.bikerentalsystem.models.Privileges> Privileges;


}

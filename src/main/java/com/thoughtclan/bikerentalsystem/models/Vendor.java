package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name="vendor", uniqueConstraints = @UniqueConstraint(columnNames ={ "email","contactNo"}))
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String contactNo;

    @Column(unique = true)
    private String email;

    private String address;


}

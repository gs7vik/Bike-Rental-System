package com.thoughtclan.bikerentalsystem.models;


import jakarta.persistence.*;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name="RoleMapping")
public class RoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "id" , nullable=false)
    private Role role;

    @ManyToOne
    @JoinColumn(name="api_id", referencedColumnName = "id" , nullable=false)
    private ApiMapping apiMapping;


}

package com.thoughtclan.bikerentalsystem.models;

import com.thoughtclan.bikerentalsystem.utils.HttpMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


import jakarta.persistence.*;

@Data
@Table(name="apimapping")
@Entity

public class ApiMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    private HttpMethod httpMethod;
}

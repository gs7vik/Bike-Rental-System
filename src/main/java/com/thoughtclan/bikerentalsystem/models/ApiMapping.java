package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.http.HttpMethod;

import jakarta.persistence.*;

@Data
@Table(name="apimapping")
@Entity
public class ApiMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private HttpMethod httpMethod;
}

package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "Role")
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column
        private Long id;

        @Column
        private String name;


    }




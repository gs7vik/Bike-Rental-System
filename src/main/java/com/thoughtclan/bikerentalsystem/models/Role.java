package com.thoughtclan.bikerentalsystem.models;
import jakarta.persistence.*;
@Entity
@Table(name="role")
public class Role {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String description;
    public Role(){
        super(); //Satvik added this no arg constructor
    }
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
         public String getDescription() {
             return description;
         }

         public void setDescription(String description) {
            this.description = description;
        }

    }



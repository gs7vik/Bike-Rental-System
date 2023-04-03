package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name="privileges")
public class privileges {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "displayName")
    private String display_Name;
    @Column(name = "description")
    private String description;

    public privileges(String name, String display_Name, String description){
        this.name=name;
        this.description=description;
        this.display_Name=display_Name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_Name() {
        return display_Name;
    }

    public void setDisplay_Name(String display_Name) {
        this.display_Name = display_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

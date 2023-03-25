package com.thoughtclan.bikerentalsystem.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role")
public class Role {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
        @Column(name = "name")
        private String name;
        @Column(name = "description")
        private String description;


    public Role(String name) {
      this.name=name;

    public Role(){
        super(); //Satvik added this no arg constructor
    }
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        }


    public Role(String name, String description,List<privileges> Privileges) {


        this.name = name;
        this.description = description;
        this.Privileges=(List<privileges>) Privileges;
    }
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="role_privileges_mapping",joinColumns=@JoinColumn(name="role_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="privileges_id",referencedColumnName="id"))
    private List<privileges> Privileges;
    public Integer getId() {
            return id;}
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



package com.thoughtclan.bikerentalsystem.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role")
public class Role {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "description")
        private String description;


    public Role(String name) {
        this.name = name;
    }

    public Role(){
        super();
    }
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        }


    public Role(String name, String description,List<com.thoughtclan.bikerentalsystem.models.Privileges> Privileges) {


        this.name = name;
        this.description = description;
        this.Privileges=(List<com.thoughtclan.bikerentalsystem.models.Privileges>) Privileges;
    }
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="role_privileges_mapping",joinColumns=@JoinColumn(name="role_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="privileges_id",referencedColumnName="id"))
    private List<com.thoughtclan.bikerentalsystem.models.Privileges> Privileges;
    public Long getId() {
            return id;}
        public void setId(Long id) {
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



package com.thoughtclan.bikerentalsystem.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private Integer age;
    private String email;
    private String password;
    @Column(name="license_no")
    private String licenseNo;
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_role_mapping",joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id"))
    private List<Role> roles;


    public User() {
        super();
        }


    public User(String firstName, String lastName, String email, String password, String licenseNo, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.licenseNo = licenseNo;
        this.roles = (List<Role>) roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}

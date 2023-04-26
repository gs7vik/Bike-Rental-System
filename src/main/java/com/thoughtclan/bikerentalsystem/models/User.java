package com.thoughtclan.bikerentalsystem.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames ={ "email","license_no"}))

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
    private String password;
    @Column(name="license_no")
    private String licenseNo;
    @Column(name="contact_no")
    private String contactNo;
//    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name="user_role_mapping",joinColumns=@JoinColumn(name="user_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id"))
//    private List<Role> roles;
@ManyToOne
@JoinColumn(name="role_id",referencedColumnName = "id")
private List<Role> roles;


    public User() {
        super();
        }

    public User(String firstName, String lastName, String email, String password, String licenseNo,String contactNo, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.licenseNo = licenseNo;
        this.contactNo = contactNo;
        this.roles = (List<Role>) roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }



}

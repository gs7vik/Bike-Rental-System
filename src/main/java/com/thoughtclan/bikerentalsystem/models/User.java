package com.thoughtclan.bikerentalsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotBlank
    @Size(min=3,message = "Please enter name with atleast 3 characters")
    private String firstName;


    @Column
    private String fireBaseId;


    @Column
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @Column
    @NotBlank
    @Pattern(regexp="^.*(?=.{6,12})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;


    @Column
    private Date dob;

    @Column(unique = true)
    private String licenseNo;

    @Column(unique = true)
    private String AadharNo;

    @Column(unique = true)
    @Pattern(regexp="^\\+?91?[6789]\\d{9}$")
    private String contactNo;

    @ManyToOne
    @JoinColumn(name="role_id",referencedColumnName = "id")
    private Role role;

}

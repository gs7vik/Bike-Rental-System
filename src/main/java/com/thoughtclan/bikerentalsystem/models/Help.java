package com.thoughtclan.bikerentalsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name="Help")
@Data
public class Help {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "User_id",referencedColumnName = "id")
    private User user;

    @Column
    private String email;

    @Column
    private String description;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy 'T' HH:mm")
    private LocalDateTime writtenOn;

    @Column
    private String contactNO;

}

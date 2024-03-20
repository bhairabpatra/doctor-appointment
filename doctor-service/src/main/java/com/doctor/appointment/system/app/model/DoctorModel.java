package com.doctor.appointment.system.app.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "doctor_tbl")
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String description;
    private String experience;
    private String specialization;
    @Column(columnDefinition = "double default 0")
    private double review;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}



//    private String password;
//    private String city;
//    private String profileUrl;
//    private int fee;
//    private String availability;
//    private String address;
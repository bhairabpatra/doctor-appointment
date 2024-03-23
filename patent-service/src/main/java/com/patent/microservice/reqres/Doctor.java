package com.patent.microservice.reqres;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String description;
    private String experience;
    private String specialization;
}

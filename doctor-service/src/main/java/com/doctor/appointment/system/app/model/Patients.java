package com.doctor.appointment.system.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patients {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private String specializationType;
    private String doctorName;
    private String address;
}

package com.doctor.appointment.system.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
    private Long id;
    private Long doctor;
    private Long patent;
    private String app_time;
}

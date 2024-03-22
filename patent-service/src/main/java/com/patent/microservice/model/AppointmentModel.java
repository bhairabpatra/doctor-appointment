package com.patent.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentModel {
    private Long id;
    private Long doctor_id;
    private Long patent_id;
    private String app_time;
}

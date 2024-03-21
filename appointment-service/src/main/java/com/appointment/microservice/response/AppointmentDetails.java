package com.appointment.microservice.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetails {

    private String doc_name;
    private String doc_phone;
    private String doc_specialization;
    private String pat_name;
    private String pat_phone;
    private String pat_email;
    private String pat_gender;
    private  String app_time;
}

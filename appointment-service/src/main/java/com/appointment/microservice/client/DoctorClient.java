package com.appointment.microservice.client;

import com.appointment.microservice.reqres.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DOCTOR-SERVICE")
public interface DoctorClient {
    @GetMapping(value = "doctor/{id}")
    public Doctor getDoctor(@PathVariable Long id);
}

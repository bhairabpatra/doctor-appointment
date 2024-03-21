package com.appointment.microservice.client;

import com.appointment.microservice.reqres.Doctor;
import com.appointment.microservice.reqres.Patent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PATENT-SERVICE")
public interface PatientClient {
    @GetMapping(value = "patient/{id}")
    public Patent getPatent(@PathVariable Long id);
}

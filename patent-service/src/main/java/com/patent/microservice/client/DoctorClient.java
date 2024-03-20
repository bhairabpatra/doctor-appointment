package com.patent.microservice.client;


import com.patent.microservice.reqres.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "DOCTOR-SERVICE")
public interface DoctorClient {

    @GetMapping(value = "doctor/specializations")
    public List<String> getAllSpecialization();

    @GetMapping(value = "doctor/doctors/{specialization}")
    public List<Doctor> getSpecializedDoctor(@PathVariable String  specialization);

    @PutMapping(value = "doctor/{docName}")
    public String Review(@PathVariable String  docName, @RequestParam Double review );

}

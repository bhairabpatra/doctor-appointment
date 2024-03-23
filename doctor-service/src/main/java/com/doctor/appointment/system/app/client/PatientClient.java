package com.doctor.appointment.system.app.client;

import com.doctor.appointment.system.app.model.AppointmentModel;
import com.doctor.appointment.system.app.model.Patients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "PATENT-SERVICE")
public interface PatientClient {
    @GetMapping(value = "patient/{id}")
    public Patients getPatent(@PathVariable Long id);
}
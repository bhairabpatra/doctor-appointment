package com.doctor.appointment.system.app.client;

import com.doctor.appointment.system.app.model.AppointmentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "APPOINTMENT-SERVICE")
public interface AppointmentClient {
    @GetMapping(value = "appointment/{id}")
    public List<AppointmentModel> getAppointmentDetails(@PathVariable Long id);
}

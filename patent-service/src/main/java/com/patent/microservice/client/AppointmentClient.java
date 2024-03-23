package com.patent.microservice.client;

import com.patent.microservice.model.AppointmentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "APPOINTMENT-SERVICE")
public interface AppointmentClient {
    @PostMapping(value = "appointment/book")
    public String makeAppointment(@RequestBody AppointmentModel appointmentModel);
}

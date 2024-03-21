package com.appointment.microservice.service;
import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.response.AppointmentDetails;

public interface AppointmentService {
    boolean doAppointment(AppointmentModel appointmentModel);

    AppointmentDetails appointmentDetails(Long dcoId, Long patId);
}

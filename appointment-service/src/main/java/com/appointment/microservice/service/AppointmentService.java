package com.appointment.microservice.service;
import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.response.AppointmentDetails;

import java.util.List;

public interface AppointmentService {
    boolean doAppointment(AppointmentModel appointmentModel);

    AppointmentDetails appointmentDetails(Long dcoId, Long patId);

    List<AppointmentModel> getAppointments(Long dcoId);
}

package com.appointment.microservice.repository;


import com.appointment.microservice.model.AppointmentModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {


}

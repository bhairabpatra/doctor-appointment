package com.appointment.microservice.controller;

import com.appointment.microservice.client.DoctorClient;

import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.reqres.Doctor;
import com.appointment.microservice.response.AppointmentDetails;
import com.appointment.microservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointment/")
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorClient doctorClient;

    @PostMapping("book")
    public ResponseEntity<String> makeAppointment(@RequestBody AppointmentModel appointmentModel) {

        if (appointmentService.doAppointment(appointmentModel)) {
            return new ResponseEntity<>("appointment Booked", HttpStatus.OK);
        }
        return new ResponseEntity<>("appointment not done", HttpStatus.OK);

    }

    @GetMapping("appointment-details/{dco_id}/{pat_id}")
    public ResponseEntity<AppointmentDetails> getDocAppointment(@PathVariable Long dco_id, @PathVariable Long pat_id) {
               AppointmentDetails appointmentDetails =  appointmentService.appointmentDetails(dco_id, pat_id);
               return  new ResponseEntity<>(appointmentDetails, HttpStatus.OK);
    }
}

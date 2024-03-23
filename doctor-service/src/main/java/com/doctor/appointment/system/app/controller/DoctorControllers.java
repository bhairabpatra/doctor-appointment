package com.doctor.appointment.system.app.controller;


import com.doctor.appointment.system.app.client.AppointmentClient;
import com.doctor.appointment.system.app.client.PatientClient;

import com.doctor.appointment.system.app.model.AppointmentModel;
import com.doctor.appointment.system.app.model.DoctorModel;
import com.doctor.appointment.system.app.model.Patients;
import com.doctor.appointment.system.app.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("doctor/")
@CrossOrigin("*")
public class DoctorControllers {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentClient appointmentClient;

    @Autowired
    private PatientClient patientsClient;

    @PostMapping("create")
    public ResponseEntity<DoctorModel> createDoc(@RequestBody DoctorModel doctorModel) {
        DoctorModel newDoc = doctorService.createDoctor(doctorModel);
        return new ResponseEntity<>(newDoc, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<DoctorModel> updateReview(@RequestBody DoctorModel doctorModel) {
        DoctorModel newDoc = doctorService.createDoctor(doctorModel);
        return new ResponseEntity<>(newDoc, HttpStatus.CREATED);
    }

    @GetMapping("doctors")
    public ResponseEntity<List<DoctorModel>> createDoc() {
        List<DoctorModel> allDoc = doctorService.getDoctors();
        return new ResponseEntity<>(allDoc, HttpStatus.OK);
    }

    @GetMapping("specializations")
    public ResponseEntity<List<String>> specializations() {
        List<String> allDoc = doctorService.getSpecializations();
        return new ResponseEntity<>(allDoc, HttpStatus.OK);
    }


    @GetMapping("doctors/{specialization}")
    public ResponseEntity<List<DoctorModel>> specializationType(@PathVariable String specialization) {
        List<DoctorModel> docSpecialization = doctorService.getSpecialization(specialization);
        return new ResponseEntity<>(docSpecialization, HttpStatus.OK);
    }

    @GetMapping("doctorsByName/{specialization}")
    public ResponseEntity<List<String>> doctorsByName(@PathVariable String specialization) {
        List<String> docNames = doctorService.getSpecializationDoctor(specialization);
        return new ResponseEntity<>(docNames, HttpStatus.OK);
    }

    @GetMapping("search/{searchItem}")
    public ResponseEntity<List<DoctorModel>> searchDoctors(@PathVariable String searchItem) {
        List<DoctorModel> searchDoctor = doctorService.getSearchDoctors(searchItem);
        return new ResponseEntity<>(searchDoctor, HttpStatus.OK);
    }

    @PutMapping("{docName}")
    public ResponseEntity<String> updateReview(@PathVariable String docName, @RequestParam Double review) {
        Optional<DoctorModel> doctorModel = Optional.ofNullable(doctorService.findDoctor(docName));
        if (doctorModel.isPresent()) {
            doctorModel.get().setReview(review);
            doctorService.createDoctor(doctorModel.get());
            return new ResponseEntity<>("Review Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Updated", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorModel> getDoctor(@PathVariable Long id) {
        DoctorModel doctor = doctorService.getDoctor(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<List<Patients>> getPatients(@PathVariable Long id) {
        List<AppointmentModel> appointmentModel = appointmentClient.getAppointmentDetails(id);

        List<Long> allPatientIds = appointmentModel.stream()
                .map(AppointmentModel::getPatent)
                .collect(Collectors.toList());

        List<Patients> patients = allPatientIds.stream()
                .map(patientsClient::getPatent)
                .collect(Collectors.toList());

        return ResponseEntity.ok(patients);
    }
}

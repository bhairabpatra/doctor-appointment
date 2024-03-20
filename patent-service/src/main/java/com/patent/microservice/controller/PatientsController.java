package com.patent.microservice.controller;

import com.patent.microservice.client.DoctorClient;
import com.patent.microservice.model.PatientModel;
import com.patent.microservice.reqres.Doctor;
import com.patent.microservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient/")
@CrossOrigin("*")
public class PatientsController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorClient doctorClient;

    @PostMapping("addPatient")
    public ResponseEntity<PatientModel> addPatients(@RequestBody PatientModel patientModel) {
        PatientModel newPatient = patientService.addPatient(patientModel);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @GetMapping("patients")
    public ResponseEntity<List<PatientModel>> getPatients() {
        List<PatientModel> patients = patientService.getPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("patient/{phone}")
    public ResponseEntity<PatientModel> getPatient(@PathVariable String phone) {
        PatientModel patient = patientService.getPatientByPhone(phone);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping("review/{docName}")
    public ResponseEntity<String> getPatient(@PathVariable String docName, @RequestParam Double review) {
        String message = doctorClient.Review(docName, review);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @GetMapping("doctor-specialization-names")
    public ResponseEntity<List<String>> getSpecializations() {
        List<String> specializations = doctorClient.getAllSpecialization();
        return new ResponseEntity<>(specializations, HttpStatus.OK);
    }

    @GetMapping("doctor-names/{specialization}")
    public ResponseEntity<List<Doctor>> getDoctorsName(@PathVariable String specialization) {
        List<Doctor> doctors = doctorClient.getSpecializedDoctor(specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}

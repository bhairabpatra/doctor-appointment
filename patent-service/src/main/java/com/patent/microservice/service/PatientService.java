package com.patent.microservice.service;


import com.patent.microservice.model.PatientModel;

import java.util.List;

public interface PatientService {

    PatientModel addPatient(PatientModel patientModel);

    PatientModel getPatientByPhone(String phone);

    List<PatientModel> getPatients();

    PatientModel getPatient(Long id);
}

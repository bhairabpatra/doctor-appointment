package com.appointment.microservice.service;

import com.appointment.microservice.client.DoctorClient;
import com.appointment.microservice.client.PatientClient;
import com.appointment.microservice.model.AppointmentModel;
import com.appointment.microservice.repository.AppointmentRepository;
import com.appointment.microservice.reqres.Doctor;
import com.appointment.microservice.reqres.Patent;
import com.appointment.microservice.response.AppointmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private PatientClient patientClient;

    @Override
    public boolean doAppointment(AppointmentModel appointmentModel) {
        AppointmentModel newAppointment = appointmentRepository.save(appointmentModel);
        if (newAppointment != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AppointmentDetails appointmentDetails(Long dcoId, Long patId) {
        AppointmentDetails appointmentinfo = new AppointmentDetails();

        Optional<Doctor> doctor = Optional.ofNullable(doctorClient.getDoctor(dcoId));
        Optional<Patent> patent = Optional.ofNullable(patientClient.getPatent(patId));
//        Optional<AppointmentModel> appointmentModel = Optional.ofNullable(appointmentRepository.findById(dcoId).get());

        if (doctor.isPresent() && patent.isPresent()) {
            appointmentinfo.setDoc_name(doctor.get().getFirstName());
            appointmentinfo.setDoc_specialization(doctor.get().getSpecialization());
            appointmentinfo.setDoc_phone(doctor.get().getPhone());
            appointmentinfo.setPat_name(patent.get().getFirstName());
            appointmentinfo.setPat_phone(patent.get().getPhone());
            appointmentinfo.setPat_email(patent.get().getEmail());
            appointmentinfo.setPat_gender(patent.get().getGender());
//            appointmentinfo.setApp_time(appointmentModel.get().getApp_time());
            return appointmentinfo;
        } else {
            return null;
        }
    }

    @Override
    public List<AppointmentModel> getAppointments(Long dcoId) {
        List<AppointmentModel> appointmentModels = appointmentRepository.findByDoctor(dcoId);
        return appointmentModels;
    }
}

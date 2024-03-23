package com.patent.microservice.service;
import com.patent.microservice.model.PatientModel;
import com.patent.microservice.repository.PatientRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientModel addPatient(PatientModel patientModel) {
//        patientModel.setToken_number(generateToken(patientModel));
        return patientRepository.save(patientModel);
    }

//    private String generateToken(PatientModel patientModel) {
//        String token = patientModel.getPhone().substring(6);
//        return token;
//    }

    @Override
    public PatientModel getPatientByPhone(String phone) {
        Optional<PatientModel> patient = patientRepository.findByPhone(phone);
        if (patient.isPresent()) {
            return patient.get();
        } else {
            return null;
        }
    }

    @Override
    public List<PatientModel> getPatients() {
        return patientRepository.findAll();
    }

    @Override
    public PatientModel getPatient(Long id) {
        Optional<PatientModel> patientModel = Optional.of(patientRepository.findById(id)).get();
        if (patientModel.isPresent()) {
            return patientModel.get();
        } else {
            return null;
        }
    }
}

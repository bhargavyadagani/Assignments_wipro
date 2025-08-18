package com.example.patient_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    public Optional<Patient> getPatient(Long id) {
        return repository.findById(id);
    }

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Patient updatePatient(Long id, Patient updated) throws Exception {
        Patient patient = repository.findById(id).orElseThrow(() -> new Exception("Patient not found"));
        patient.setFirstName(updated.getFirstName());
        patient.setLastName(updated.getLastName());
        patient.setEmail(updated.getEmail());
        patient.setPhone(updated.getPhone());
        patient.setInsuranceProvider(updated.getInsuranceProvider());
        patient.setInsuranceNumber(updated.getInsuranceNumber());
        return repository.save(patient);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}

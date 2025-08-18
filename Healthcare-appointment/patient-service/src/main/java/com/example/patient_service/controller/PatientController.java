package com.example.patient_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient_service.model.Patient;
import com.example.patient_service.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return service.createPatient(patient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatient(@PathVariable Long id) {
        return service.getPatient(id);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) throws Exception {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
    }
}

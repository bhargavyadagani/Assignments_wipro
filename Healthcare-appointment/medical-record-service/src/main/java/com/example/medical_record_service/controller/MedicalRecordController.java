package com.example.medical_record_service.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.medical_record_service.dto.MedicalRecordDto;
import com.example.medical_record_service.dto.PatientDto;
import com.example.medical_record_service.dto.PatientMedicalRecordsDto;
import com.example.medical_record_service.feign.PatientClient;
import com.example.medical_record_service.model.MedicalRecord;
import com.example.medical_record_service.service.MedicalRecordService;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;
    
    @Autowired
    private PatientClient patientClient;

    // Create a new medical record
    @PostMapping
    public MedicalRecord createRecord(@RequestBody MedicalRecord record) {
        return service.createRecord(record);
    }

    // Get a record by its ID (only numbers allowed)
    @GetMapping("/{id:[0-9]+}")
    public Optional<MedicalRecord> getRecord(@PathVariable Long id) {
        return service.getRecord(id);
    }

    @GetMapping("/patient/{patientId:[0-9]+}")
    public List<MedicalRecordDto> getRecordsByPatient(@PathVariable Long patientId) {
        return service.getRecordsByPatient(patientId)
            .stream()
            .map(record -> {
                MedicalRecordDto dto = new MedicalRecordDto();
                dto.setId(Long.valueOf(record.getId()));
                dto.setPatientId(record.getPatientId());
                dto.setDoctorId(record.getDoctorId());
                dto.setVisitDate(record.getVisitDate());
                dto.setDiagnosis(record.getDiagnosis());
                dto.setPrescription(record.getPrescription());
                dto.setLabResults(record.getLabResults());
                return dto;
            })
            .collect(Collectors.toList());
    }

    // Update a record by ID
    @PutMapping("/{id:[0-9]+}")
    public MedicalRecord updateRecord(@PathVariable Long id, @RequestBody MedicalRecord record) throws Exception {
        return service.updateRecord(id, record);
    }

    // Delete a record by ID
    @DeleteMapping("/{id:[0-9]+}")
    public void deleteRecord(@PathVariable Long id) {
        service.deleteRecord(id);
    }
}

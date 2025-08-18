package com.example.medical_record_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medical_record_service.model.MedicalRecord;

public interface MedicalrecordRepository extends JpaRepository<MedicalRecord, Long> {

	List<MedicalRecord> findByPatientId(Long patientId);

}

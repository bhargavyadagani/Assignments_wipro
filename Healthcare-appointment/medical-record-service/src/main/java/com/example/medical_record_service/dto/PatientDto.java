package com.example.medical_record_service.dto;

import lombok.Data;

@Data
public class PatientDto {
	
	private Long id;
    private String firstName;
    private String insuranceNumber;
    private String phone;
}

package com.example.billing_service.dto;

import lombok.Data;

@Data
public class AppointmentDto {
	
	private Long id;
    private Long doctorId;
    private Long patientId;
    private String status;
}

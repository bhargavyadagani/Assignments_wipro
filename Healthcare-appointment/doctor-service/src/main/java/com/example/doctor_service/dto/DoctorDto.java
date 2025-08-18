package com.example.doctor_service.dto;

import lombok.Data;

@Data
public class DoctorDto {

	private Long id;
    private String name;
    private String specialization;
    private boolean available;
	public DoctorDto(Long id, String name, String specialization, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.available = available;
	}
    
    
}

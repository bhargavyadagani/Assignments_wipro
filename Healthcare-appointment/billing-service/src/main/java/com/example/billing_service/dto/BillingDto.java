package com.example.billing_service.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BillingDto {
	private Long id;
    private Long patientId;
    private Long appointmentId;
    private Double amount;
    private String status;
    private LocalDateTime createdAt;
}

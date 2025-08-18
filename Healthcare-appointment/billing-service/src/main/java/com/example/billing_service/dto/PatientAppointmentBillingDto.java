package com.example.billing_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentBillingDto {
    private PatientDto patient;
    private AppointmentDto appointment;
    private BillingDto billing;
}

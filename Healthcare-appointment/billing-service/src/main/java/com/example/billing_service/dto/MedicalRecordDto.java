package com.example.billing_service.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class MedicalRecordDto {
    private Long id;
    private Long patientId;
    private Long doctorId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;

    private String diagnosis;
    private String prescription;
    private String labResults;
}

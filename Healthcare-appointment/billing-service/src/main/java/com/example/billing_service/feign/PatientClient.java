package com.example.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.billing_service.dto.PatientDto;

@FeignClient(name = "patient-service", url = "http://localhost:1001")
public interface PatientClient {
    @GetMapping("/patients/{id}")
    PatientDto getPatientById(@PathVariable("id") Long id);
}

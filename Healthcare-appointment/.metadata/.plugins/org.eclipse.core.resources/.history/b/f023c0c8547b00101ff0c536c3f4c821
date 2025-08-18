package com.example.doctor_service.controller;

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

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return service.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable Long id) {
        return service.getDoctor(id);
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    @PutMapping("/update/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) throws Exception {
        return service.updateDoctor(id, doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
    }

    @PostMapping("/{id}/block")
    public boolean blockSlot(@PathVariable Long id) {
        return service.blockSlot(id);
    }

    @PostMapping("/{id}/release")
    public void releaseSlot(@PathVariable Long id) {
        service.releaseSlot(id);
    }
}

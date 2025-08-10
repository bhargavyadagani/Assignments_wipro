package com.example.theater_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.theater_service.model.Theater;
import com.example.theater_service.service.TheaterService;

@RestController
@RequestMapping("/api")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheater();
    }

    @GetMapping("/{id}")
    public Theater getTheaterById(@PathVariable Long id) {
        return theaterService.getTheaterById(id)
                .orElseThrow(() -> new RuntimeException("Theater not found"));
    }

    @PostMapping
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @PutMapping("/{id}")
    public Theater updateTheater(@PathVariable Long id, @RequestBody Theater theater) {
        return theaterService.updateTheater(id, theater);
    }

    @DeleteMapping("/{id}")
    public void deleteTheater(@PathVariable Long id) {
        theaterService.deleteTheater(id);
    }
}



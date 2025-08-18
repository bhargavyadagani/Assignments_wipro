package com.example.course_service.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_service.dto.UserDto;
import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
    private  CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }
    
    @GetMapping("/{id}/details")
    public ResponseEntity<?> getCourseDetails(@PathVariable Long id) {
        Course course = service.getCourseById(id);
        UserDto teacher = service.getTeacherDetails(course.getTeacherId());
        return ResponseEntity.ok(Map.of(
                "course", course,
                "teacher", teacher
        ));
    }
}


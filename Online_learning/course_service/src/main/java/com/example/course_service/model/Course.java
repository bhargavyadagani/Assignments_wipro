package com.example.course_service.model;

import com.example.course_service.enunm.CourseCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private CourseCategory category;
	private Long teacherId;
	
}

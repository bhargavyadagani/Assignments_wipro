package com.example.classroom_service.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ClassroomDto {

	private Long id;
    private String topic;
    private LocalDateTime sessionDate;

    private CourseDto course;
    private List<StudentAttendenceDto> students;
	public ClassroomDto(Long id, String topic, LocalDateTime sessionDate, CourseDto course,
			List<StudentAttendenceDto> students) {
		super();
		this.id = id;
		this.topic = topic;
		this.sessionDate = sessionDate;
		this.course = course;
		this.students = students;
	}
    
    
}

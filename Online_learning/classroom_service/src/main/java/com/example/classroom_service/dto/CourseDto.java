package com.example.classroom_service.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
	private Long id;
    private String title;
    private String category;
    private Long teacherId;
    private List<UserDto> students;
}

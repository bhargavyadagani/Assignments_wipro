package com.example.classroom_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendenceDto {
	private UserDto student;   
    private boolean present;
}

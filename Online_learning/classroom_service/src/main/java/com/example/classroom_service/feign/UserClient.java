package com.example.classroom_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.classroom_service.dto.UserDto;

@FeignClient(name="user-service",url="http://localhost:2001")
public interface UserClient {

	@GetMapping("/user/{id}")
    UserDto getById(@PathVariable Long id);
	
	@GetMapping("/users/course/{courseId}")
    List<UserDto> getStudentsByCourse(@PathVariable("courseId") Long courseId);
}

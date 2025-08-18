package com.example.classroom_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.classroom_service.model.Attendance;

public interface AttendenceRepository extends JpaRepository<Attendance,Long> {
	List<Attendance> findByClassroomId(Long classroomId);
}

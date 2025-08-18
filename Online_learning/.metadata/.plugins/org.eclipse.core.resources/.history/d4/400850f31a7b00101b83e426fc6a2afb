package com.example.assessment_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment_service.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByStudentId(Long studentId);
    List<Submission> findByAssessmentId(Long assessmentId);
}

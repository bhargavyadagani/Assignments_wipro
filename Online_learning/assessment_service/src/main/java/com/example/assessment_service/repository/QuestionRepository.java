package com.example.assessment_service.repository;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment_service.model.Questions;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Questions> findByAssessmentId(Long assessmentId);

	Questions save(Questions question);
}

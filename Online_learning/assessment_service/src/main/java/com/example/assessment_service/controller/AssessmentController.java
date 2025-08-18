package com.example.assessment_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.model.Questions;
import com.example.assessment_service.model.Submission;
import com.example.assessment_service.service.AssessmentService;


@RestController
@RequestMapping("/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    // Create assessment
    @PostMapping
    public Assessment createAssessment(@RequestBody Assessment assessment) {
        return assessmentService.createAssessment(assessment);
    }

    // Add question to quiz
    @PostMapping("/{id}/questions")
    public Questions addQuestion(@PathVariable Long id, @RequestBody Questions question) {
        return assessmentService.addQuestion(id, question);
    }

    // Submit answer
    @PostMapping("/submit")
    public Submission submitAnswer(@RequestBody Submission submission) {
        return assessmentService.submitAnswer(submission);
    }

    // Get results of a student
    @GetMapping("/student/{studentId}/results")
    public List<Submission> getStudentResults(@PathVariable Long studentId) {
        return assessmentService.getStudentResults(studentId);
    }

    // Get submissions for an assessment
    @GetMapping("/{id}/submissions")
    public List<Submission> getAssessmentSubmissions(@PathVariable Long id) {
        return assessmentService.getAssessmentSubmissions(id);
    }
}

package com.example.assessment_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment_service.model.Assessment;
import com.example.assessment_service.model.Questions;
import com.example.assessment_service.model.Submission;
import com.example.assessment_service.repository.AssessmentRepository;
import com.example.assessment_service.repository.QuestionRepository;
import com.example.assessment_service.repository.SubmissionRepository;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    // Create assessment
    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    // Add question to quiz
    public Questions addQuestion(Long assessmentId, Questions question) {
        question.setAssessmentId(assessmentId);
        return questionRepository.save(question);
    }

    // Student submits answer
    public Submission submitAnswer(Submission submission) {
        Assessment assessment = assessmentRepository.findById(submission.getAssessmentId())
                .orElseThrow(() -> new RuntimeException("Assessment not found"));

        // Auto-grading for quiz
        if ("QUIZ".equalsIgnoreCase(assessment.getType())) {
            List<Questions> questions = questionRepository.findByAssessmentId(assessment.getId());

            for (Questions q : questions) {
                if (submission.getAnswerText().equalsIgnoreCase(q.getCorrectAnswer())) {
                    submission.setScore(1.0); 
                } else {
                    submission.setScore(0.0);
                }
            }
        }

        submission.setSubmittedAt(LocalDateTime.now());
        return submissionRepository.save(submission);
    }

    // Get all results of a student
    public List<Submission> getStudentResults(Long studentId) {
        return submissionRepository.findByStudentId(studentId);
    }

    // Get all submissions for an assessment
    public List<Submission> getAssessmentSubmissions(Long assessmentId) {
        return submissionRepository.findByAssessmentId(assessmentId);
    }
}

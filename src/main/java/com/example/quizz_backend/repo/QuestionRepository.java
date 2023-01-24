package com.example.quizz_backend.repo;

import com.example.quizz_backend.model.exam.Question;
import com.example.quizz_backend.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long>{

    Set<Question> findByQuiz(Quiz quiz);
}

package com.example.quizz_backend.controller;

import com.example.quizz_backend.model.exam.Quiz;
import com.example.quizz_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;


    // add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //getting quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());

    }

    //grt single quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid")Long qid)
    {
        return this.quizService.getQuiz(qid);
    }

    //delete quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid)
    {
        this.quizService.deleteQuiz(qid);
    }

}
package com.example.quizz_backend.controller;

import com.example.quizz_backend.model.exam.Question;
import com.example.quizz_backend.model.exam.Quiz;
import com.example.quizz_backend.service.QuestionService;
import com.example.quizz_backend.service.QuizService;
import javafx.print.Collation;
import org.hibernate.internal.ConnectionObserverStatsBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.sql.Connection;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;


    // add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //getting all question of any quid
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid) {
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionOfQuiz = this.service.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionOfQuiz);

       Quiz quiz= this.quizService.getQuiz(qid);
     Set<Question> questions=  quiz.getQuestions();
     List list = new ArrayList(questions);
     if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
     {
         list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
     }
        Collections.shuffle(list);
     return ResponseEntity.ok(list);



    }

    //grt single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId")Long quesId)
    {
        return this.service.getQuestion(quesId);
    }

    //delete quiz
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId)
    {
       this.service.deleteQuestion(quesId);
    }

}

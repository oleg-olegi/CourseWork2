package com.example.coursework2.controller;

import com.example.coursework2.questionclass.Question;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")

public class JavaQuestionController {

    private QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestions") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java")
    public Collection<Question> getAllQuestions() {
        return questionService.getAll();
    }


    @GetMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
        return "successfully added";
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question questionToRemove = new Question(question, answer);
        questionService.remove(questionToRemove);
        return "successfully removed";
    }
}

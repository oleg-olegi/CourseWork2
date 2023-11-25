package com.example.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {


 /*   @GetMapping
    public JavaController getAllQuestions(QuestionService service) {
        return null;
    }*/


    @GetMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        return null;
    }

    @GetMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return null;
    }
}

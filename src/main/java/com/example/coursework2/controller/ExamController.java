package com.example.coursework2.controller;

import com.example.coursework2.questionclass.Question;
import com.example.coursework2.service.ExaminerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
@AllArgsConstructor
public class ExamController {
    private ExaminerService service;

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestions(amount);
    }
}

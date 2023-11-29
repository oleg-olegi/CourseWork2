package com.example.coursework2.controller;

import com.example.coursework2.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class MathQuestionController {
    @Qualifier("mathQuestions")
    private QuestionService questionService;

}

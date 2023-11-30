package com.example.coursework2.controller;

import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class MathQuestionController {

    private final QuestionService questionService;


    public MathQuestionController(@Qualifier("mathQuestions") QuestionService questionService) {
        this.questionService = questionService;
    }

}

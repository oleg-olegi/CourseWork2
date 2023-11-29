package com.example.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
@Component
@Qualifier("mathQuestions")
public class MathQuestionService implements QuestionService{
    @Override
    public void add(String question, String answer) {

    }

    @Override
    public void add(Object question) {

    }

    @Override
    public void remove(Object question) {

    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Object getRandomQuestion() {
        return null;
    }
}

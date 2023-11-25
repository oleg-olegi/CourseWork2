package com.example.coursework2.service;

import com.example.coursework2.Question;

import java.util.Collection;

public interface QuestionService<T> {
    void add(T question, T answer);

    void add(T question);

    void remove(T question);

    Collection<Question> getAll();

   Question getRandomQuestion();

}

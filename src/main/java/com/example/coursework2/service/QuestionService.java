package com.example.coursework2.service;

import java.util.Collection;

public interface QuestionService<T> {
    void add(String question, String answer);

    void add(T question);

    void remove(T question);

    Collection<T> getAll();

   T getRandomQuestion();

}

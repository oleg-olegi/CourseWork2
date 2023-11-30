package com.example.coursework2.repository;

import java.util.Collection;

public interface QuestionRepository<T> {
    void addQuestionFromString(String question, String answer);

    void add(T question);

    void remove(T question);

    Collection<T> getAll();


}

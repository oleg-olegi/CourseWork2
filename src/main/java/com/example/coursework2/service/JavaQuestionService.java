package com.example.coursework2.service;

import com.example.coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService<String> {
    private Set<Question> questionSet;

    public JavaQuestionService() {
        questionSet = new HashSet<>(10);
    }

    @Override
    public void add(String question, String answer) {
        questionSet.add(new Question(question, answer));
    }

    @Override
    public void add(String question) {
        questionSet.add(new Question(question));
    }


    @Override
    public void remove(String question) {
        questionSet.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        int rndNum = new Random().nextInt(questionSet.size());
        Object[] array = questionSet.toArray();
        return (Question) array[rndNum];
    }
}

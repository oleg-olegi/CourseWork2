package com.example.coursework2.service;

import com.example.coursework2.questionclass.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Component
@Qualifier("mathQuestions")
public class MathQuestionService implements QuestionService<Question> {
    private Set<Question> questionSet;
    private Random random;

    public MathQuestionService() {
        questionSet = new HashSet<>(10);
        random = new Random();
    }

    @Override
    public void add(String question, String answer) {
        questionSet.add(new Question(question, answer));
    }

    @Override
    public void add(Question question) {
        questionSet.add(question);
    }

    @Override
    public void remove(Question question) {
        questionSet.remove(question);
    }

    @Override
    public Collection getAll() {

        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}

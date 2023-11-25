package com.example.coursework2.service;

import com.example.coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService<Question> {
    private Set<Question> questionSet;
    private int countOfQuestions = 0;

    public JavaQuestionService() {
        questionSet = new HashSet<>(10);
    }

    @Override
    public void add(String question, String answer) {
        questionSet.add(new Question(question, answer));
        countOfQuestions++;
    }

    @Override
    public void add(Question question) {
        questionSet.add(question);
        countOfQuestions++;
    }

    @Override
    public void remove(Question question) {
        questionSet.remove(question);
        countOfQuestions--;
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        if (!questionSet.isEmpty()) {
            int rndNum = new Random().nextInt(questionSet.size());
            List<Question> questionsList = new ArrayList<>(questionSet);
            return questionsList.get(rndNum);
        } else throw new RuntimeException("Set is empty");
    }
}

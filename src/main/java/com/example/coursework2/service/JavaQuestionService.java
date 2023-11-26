package com.example.coursework2.service;

import com.example.coursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService<Question> {
    private Set<Question> questionSet;
    private Random random;

    public JavaQuestionService() {
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
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        if (!questionSet.isEmpty()) {
            int rndNum = random.nextInt(questionSet.size());
            List<Question> questionsList = new ArrayList<>(questionSet);
            return questionsList.get(rndNum);
        } else throw new RuntimeException("Set is empty");
    }
}

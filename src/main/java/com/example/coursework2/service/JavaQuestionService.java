package com.example.coursework2.service;

import com.example.coursework2.questionclass.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
@Qualifier("javaQuestions")
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
        if (questionSet.contains(question)) {
            questionSet.remove(question);
        } else throw new IllegalArgumentException("Question is not found");
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        if (!questionSet.isEmpty()&&questionSet.size()!=1) {
            int rndNum = random.nextInt(questionSet.size());
            List<Question> questionsList = new ArrayList<>(questionSet);
            return questionsList.get(rndNum);
        } else throw new RuntimeException("Set is empty");
    }
}

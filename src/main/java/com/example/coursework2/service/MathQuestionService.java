package com.example.coursework2.service;

import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import com.example.coursework2.questionclass.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if (!questionSet.contains(question)) {
            throw new AmountMoreThanQuestionsQuantityException("Question is not found");
        }
        questionSet.remove(question);
    }

    @Override
    public Collection getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        if (!questionSet.isEmpty() && questionSet.size() != 1) {
            int rndNum = random.nextInt(questionSet.size());
            List<Question> questionList = new ArrayList<>(questionSet);
            return questionList.get(rndNum);
        } else throw new RuntimeException("Set is empty");
    }
}

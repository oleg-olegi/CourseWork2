package com.example.coursework2.repository;

import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import com.example.coursework2.questionclass.Question;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Component
public class MathRepository implements QuestionRepository<Question> {
    private final Set<Question> questionSet;
private static final int INITIAL_CAPACITY = 10;

    public MathRepository() {
        this.questionSet = new HashSet<>(INITIAL_CAPACITY);
    }

    public void addQuestionFromString(String question, String answer) {
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

}

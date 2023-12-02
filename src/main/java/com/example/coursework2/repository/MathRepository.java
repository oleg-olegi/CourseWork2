package com.example.coursework2.repository;

import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import com.example.coursework2.questionclass.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.example.coursework2.constants.QuestionConstants.MATH_QUESTIONS;

@Repository
@Component
@Qualifier("mathRepository")
public class MathRepository implements QuestionRepository {
    private final Set<Question> questionSet;
    private static final int INITIAL_CAPACITY = 10;

    public MathRepository() {
        this.questionSet = new HashSet<>(INITIAL_CAPACITY);
    }

    @PostConstruct
    private void init() {
        questionSet.addAll(MATH_QUESTIONS);
    }


    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionSet.contains(question)) {
            throw new AmountMoreThanQuestionsQuantityException("Question is not found");
        }
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection getAll() {
        return questionSet;
    }

}

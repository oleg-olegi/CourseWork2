package com.example.coursework2.repository;

import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import com.example.coursework2.questionclass.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Component
@Qualifier("mathRepository")
public class MathRepository implements QuestionRepository {
    private final Set<Question> questionSet;
    private static final int INITIAL_CAPACITY = 10;

    public MathRepository() {
        this.questionSet = new HashSet<>(INITIAL_CAPACITY);
    }

    public Question addQuestionFromString(String question, String answer) {
        Question result = (new Question(question, answer));
        questionSet.add(result);
        return result;
    }

    @Override
    public Question add(String question, String answer) {
        Question result = new Question(question, answer);
        questionSet.add(result);
        return result;
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

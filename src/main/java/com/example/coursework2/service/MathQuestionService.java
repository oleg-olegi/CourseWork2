package com.example.coursework2.service;

import com.example.coursework2.questionclass.Question;
import com.example.coursework2.repository.MathRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
@Qualifier("mathQuestions")
public class MathQuestionService implements QuestionService<Question> {
    private MathRepository mathRepository;
    private Random random;

    public MathQuestionService(MathRepository mathRepository) {
        this.mathRepository = mathRepository;
        /* questionSet = new HashSet<>(10);*/
        random = new Random();
    }

    @Override
    public void add(String question, String answer) {
        mathRepository.addQuestionFromString(question, answer);
    }

    @Override
    public void add(Question question) {
        mathRepository.add(question);
    }

    @Override
    public void remove(Question question) {
        mathRepository.remove(question);
    }

    @Override
    public Collection getAll() {
        return mathRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = mathRepository.getAll();
        if (!allQuestions.isEmpty()) {
            int rndNum = random.nextInt(allQuestions.size());
            List<Question> questionList = new ArrayList<>(allQuestions);
            return questionList.get(rndNum);
        } else {
            throw new NoSuchElementException("Set is empty");
        }
    }
}

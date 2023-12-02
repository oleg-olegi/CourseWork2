package com.example.coursework2.service;

import com.example.coursework2.questionclass.Question;
import com.example.coursework2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
@Qualifier("mathQuestions")
public class MathQuestionService implements QuestionService {
    private QuestionRepository repository;
    private Random random;

    @Autowired
    public MathQuestionService(@Qualifier("mathRepository") QuestionRepository repository) {
        this.repository = repository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question resault = new Question(question, answer);
        return repository.add(resault);
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> allQuestions = repository.getAll();
        if (!allQuestions.isEmpty()) {
            int rndNum = random.nextInt(allQuestions.size());
            List<Question> questionList = new ArrayList<>(allQuestions);
            return questionList.get(rndNum);
        } else {
            throw new NoSuchElementException("Set is empty");
        }
    }
}

package com.example.coursework2.service;

import com.example.coursework2.Question;
import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> questionListForExam = new ArrayList<>(amount);//список для хранения вопросов для экзамена
        Collection<Question> allQuestions = questionService.getAll();//список всех вопросов
        List<Question> questionList = new ArrayList<>(allQuestions);//список всех вопросов, приведенный к лист
        int totalQuestions = allQuestions.size();
        if (amount > totalQuestions) {
            throw new AmountMoreThanQuestionsQuantityException("Запрос превышает фактическое количество содержимого");
        }
        for (int i = 0; i < amount; i++) {
            Question randomQuestion = getRandomUniqueQuestion(questionList, questionListForExam);
            questionListForExam.add(i, randomQuestion);
            questionList.remove(randomQuestion);
        }
        return questionListForExam;
    }

    private Question getRandomUniqueQuestion(List<Question> questions, List<Question> questionListForExam) {
        int totalQuestions = questions.size();
        while (true) {
            int randomIndex = random.nextInt(totalQuestions);
            Question selectedQuestion = questions.get(randomIndex);
            if (!questionListForExam.contains(selectedQuestion)) {
                return selectedQuestion;
            }
        }
    }
}

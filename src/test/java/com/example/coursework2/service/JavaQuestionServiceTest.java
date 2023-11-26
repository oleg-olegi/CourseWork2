package com.example.coursework2.service;

import com.example.coursework2.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    private Question questionMock = mock(Question.class);

    @BeforeEach
    void setJavaQuestionService() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void addTest() {
        String question = "Question";
        String answer = "Answer";
        Question addedQuestion = new Question(question, answer);//expected
        javaQuestionService.add(question, answer);//actual
        //проверяем, что объект добавлен в коллекцию
        Collection<Question> allQuestions = javaQuestionService.getAll();
        Assertions.assertTrue(allQuestions.contains(addedQuestion));
    }

    @Test
    void addQuestionObjectTest() {
        when(questionMock.getQuestion()).thenReturn("QuestionText");
        when(questionMock.getAnswer()).thenReturn("AnswerText");
        javaQuestionService.add(questionMock);
        Collection<Question> questionSet = javaQuestionService.getAll();
        Assertions.assertTrue(questionSet.contains(questionMock));
    }
    // Переопределение equals и hashCode в мок-объекте Question
    static class MockQuestion extends Question {
        public MockQuestion(String question, String answer) {
            super(question, answer);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Question question = (Question) o;
            return java.util.Objects.equals(getQuestion(), question.getQuestion()) &&
                    java.util.Objects.equals(getAnswer(), question.getAnswer());
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(getQuestion(), getAnswer());
        }
    }

    @Test
    void removeTest() {

    }
}

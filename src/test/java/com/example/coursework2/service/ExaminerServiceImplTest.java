package com.example.coursework2.service;

import com.example.coursework2.Question;
import com.example.coursework2.exceptions.AmountMoreThanQuestionsQuantityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private JavaQuestionService questionService;

    @BeforeEach
    void initService() {
        examinerService = new ExaminerServiceImpl(questionService);
    }

    static Stream<Arguments> questionsProvider() {
        return Stream.of(Arguments.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3")));
    }

    @ParameterizedTest
    @MethodSource("questionsProvider")
    void getQuestionsTest_willReturnSomeUniqueQuestions(Question question1, Question question2, Question question3) {
        when(questionService.getAll()).thenReturn(List.of(question1, question2));
        Collection<Question> collection = examinerService.getQuestions(2);
        Assertions.assertEquals(2, collection.size());
        Assertions.assertTrue(collection.contains(question1));
        Assertions.assertTrue(collection.contains(question2));
        Assertions.assertFalse(collection.contains(question3));
    }

    @ParameterizedTest
    @MethodSource("questionsProvider")
    void getQuestionsTest_willThrowsAmountMoreThanQuestionsQuantityExcp(Question question1,
                                                                        Question question2, Question question3) {
        when(questionService.getAll()).thenReturn(List.of(question1, question2));
        Collection<Question> collection = examinerService.getQuestions(2);
        Assertions.assertThrows(AmountMoreThanQuestionsQuantityException.class,
                () -> examinerService.getQuestions(3));
    }
}

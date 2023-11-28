package com.example.coursework2.service;

import com.example.coursework2.Question;
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
    private ExaminerServiceImpl service;
    @Mock
    private JavaQuestionService questionService;
    @Mock
    private Random random;

    @BeforeEach
    void initService() {
        service = new ExaminerServiceImpl(questionService);
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
        questionService.add(question1);
        questionService.add(question2);
        questionService.add(question3);
        when(service.getQuestions(2)).thenReturn(List.of(question1,question2));
        Collection<Question> collection = service.getQuestions(2);//тут закончил не работает
        Assertions.assertEquals(2, collection.size());

    }
}

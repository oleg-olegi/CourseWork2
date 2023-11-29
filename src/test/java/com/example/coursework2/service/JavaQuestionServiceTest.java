package com.example.coursework2.service;

import com.example.coursework2.questionclass.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    private Question questionMock = mock(Question.class);

    private Random random = mock(Random.class);

    @BeforeEach
    void setJavaQuestionService() {
        javaQuestionService = new JavaQuestionService();
    }

    static Stream<Arguments> argumentsStream() {
        return Stream.of(Arguments.of("Question", "Answer"));
    }

    static Stream<Arguments> questionsProvider() {
        return Stream.of(Arguments.of(
                new Question("Question1", "Answer1"),
                new Question("Question2", "Answer2"),
                new Question("Question3", "Answer3")));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void addTest(String question, String answer) {
        Question addedQuestion = new Question(question, answer);//expected
        javaQuestionService.add(question, answer);//actual
        //проверяем, что объект добавлен в коллекцию
        Collection<Question> allQuestions = javaQuestionService.getAll();
        assertTrue(allQuestions.contains(addedQuestion));
    }

    @Test
    void addQuestionObjectTest() {
        when(questionMock.getQuestion()).thenReturn("QuestionText");
        when(questionMock.getAnswer()).thenReturn("AnswerText");
        javaQuestionService.add(questionMock);
        Collection<Question> questionSet = javaQuestionService.getAll();
        assertTrue(questionSet.contains(questionMock));
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    void removeTest(String question, String answer) {
        javaQuestionService.add(question, answer);
        Collection<Question> questionSet = javaQuestionService.getAll();
        Question questionToRemove = new Question(question, answer);
        javaQuestionService.remove(questionToRemove);
        assertTrue(questionSet.isEmpty());
        assertFalse(questionSet.contains(questionToRemove));
        assertThrows(IllegalArgumentException.class, () -> javaQuestionService.remove(questionToRemove));
    }

    @ParameterizedTest
    @MethodSource("questionsProvider")
    void getAllTest(Question question1, Question question2, Question question3) {
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        Collection<Question> questions = javaQuestionService.getAll();
        assertTrue(
                questions.contains(question1) &&
                        questions.contains(question2) &&
                        questions.contains(question3));
        assertEquals(3, questions.size());
    }

    @ParameterizedTest
    @MethodSource("questionsProvider")
    void getRandomQuestionTest(Question question1, Question question2, Question question3) {
        assertThrows(RuntimeException.class, () -> javaQuestionService.getRandomQuestion());
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        javaQuestionService.add(question3);
        when(random.nextInt(3)).thenReturn(1);
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        Collection<Question> collection = javaQuestionService.getAll();
        assertNotNull(randomQuestion);
        assertTrue(collection.contains(question1) ||
                collection.contains(question2) ||
                collection.contains(question3));
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
}

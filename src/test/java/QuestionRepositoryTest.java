package repository;

import model.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionRepositoryTest {


    @Test
    void repositoryShouldReturnQuestions() {

        QuestionRepository repository =
                new QuestionRepository();


        List<Question> questions =
                repository.getQuestions();


        assertNotNull(questions);


        assertEquals(
                6,
                questions.size()
        );

    }


    @Test
    void firstQuestionShouldBelongToOracle() {

        QuestionRepository repository =
                new QuestionRepository();


        Question question =
                repository.getQuestions().get(0);


        assertEquals(
                "Oracle",
                question.getCompany()
        );


        assertEquals(
                "Какой принцип ООП позволяет скрывать внутреннюю реализацию объекта?",
                question.getText()
        );

    }

}
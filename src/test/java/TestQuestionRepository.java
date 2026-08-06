import model.Question;
import repository.QuestionRepository;

import java.util.List;

public class TestQuestionRepository {

    public static void main(String[] args) {


        QuestionRepository repository = new QuestionRepository();


        List<Question> questions = repository.getQuestions();


        for (Question question : questions) {

            System.out.println("Компания: " + question.getCompany());

            System.out.println("Вопрос: " + question.getText());

            System.out.println("Ответы:");

            question.getAnswers()
                    .forEach(answer ->
                            System.out.println(answer.getText())
                    );
        }
    }
}
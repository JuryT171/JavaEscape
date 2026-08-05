import model.Answer;
import model.Question;

import java.util.List;


public class TestQuestion {

    public static void main(String[] args) {


        Answer answer1 = new Answer("Java", true);
        Answer answer2 = new Answer("Python", false);
        Answer answer3 = new Answer("HTML", false);


        Question question = new Question(
                1,
                "Oracle",
                "Какой язык используется в Java?",
                List.of(answer1, answer2, answer3)
        );


        System.out.println(question);

    }
}

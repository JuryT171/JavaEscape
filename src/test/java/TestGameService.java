import model.GameState;
import model.Player;
import model.Question;
import service.GameService;


public class TestGameService {

    public static void main(String[] args) {

        Player player = new Player("Jury");

        GameState state = new GameState(player);

        GameService service = new GameService();


        Question question =
                service.getCurrentQuestion(state);


        System.out.println(question.getCompany());


        // выбираем Инкапсуляцию
        // она находится под индексом 1

        service.processAnswer(
                state,
                question,
                1
        );

        System.out.println(
                "Правильных ответов: "
                        + state.getCorrectAnswers()
        );

        System.out.println(
                "Следующая дверь: "
                        + service.getCurrentQuestion(state).getCompany()
        );
    }
}
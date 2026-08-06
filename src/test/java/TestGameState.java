import model.GameState;
import model.Player;
import model.Question;


public class TestGameState {

    public static void main(String[] args) {


        Player player = new Player("Jury");

        GameState game = new GameState(player);


        game.addCorrectAnswer();
        game.addCorrectAnswer();

        game.moveToNextQuestion();


        System.out.println(
                "Игрок: " + game.getPlayer().getName()
        );

        System.out.println(
                "Правильных: " + game.getCorrectAnswers()
        );

        System.out.println(
                "Вопрос №: " + game.getCurrentQuestionId()
        );

    }
}


import model.GameState;
import model.Player;
import model.Question;
import org.junit.jupiter.api.Test;
import service.GameService;

import static org.junit.jupiter.api.Assertions.*;

public class GameServiceTest {


    @Test
    void correctAnswerShouldMoveGameForward() {

        GameService gameService = new GameService();

        Player player = new Player("Jury");

        GameState state = new GameState(player);


        Question question =
                gameService.getCurrentQuestion(state);


        gameService.processAnswer(
                state,
                question,
                1
        );


        assertEquals(
                1,
                state.getCorrectAnswers()
        );


        assertEquals(
                1,
                state.getCurrentQuestionId()
        );

    }

    @Test
    void wrongAnswerShouldFinishGame() {

        GameService gameService = new GameService();

        Player player = new Player("Jury");

        GameState state = new GameState(player);


        Question question =
                gameService.getCurrentQuestion(state);


        gameService.processAnswer(
                state,
                question,
                0
        );


        assertTrue(
                state.isFinished()
        );


        assertFalse(
                state.isWon()
        );

    }

}

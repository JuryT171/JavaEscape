package service;

import model.GameState;
import model.Question;
import repository.QuestionRepository;

public class GameService {


    private final QuestionRepository questionRepository;


    public GameService() {

        this.questionRepository = new QuestionRepository();

    }


    public Question getCurrentQuestion(GameState state) {

        return questionRepository
                .getQuestions()
                .get(state.getCurrentQuestionId());

    }

    public void processAnswer(
            GameState state,
            Question question,
            int answerIndex) {

        if (question.checkAnswer(answerIndex)) {

            state.addCorrectAnswer();

            if (state.getCurrentQuestionId()
                    == questionRepository.getQuestions().size() - 1) {

                state.finishGame(true);

            } else {

                state.moveToNextQuestion();
            }

        } else {

            state.finishGame(false);
        }
    }
}
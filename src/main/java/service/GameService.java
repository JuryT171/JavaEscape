package service;

import model.GameState;
import model.Question;
import repository.QuestionRepository;

// логика
public class GameService {

    private final QuestionRepository questionRepository;
    public GameService() {
        this.questionRepository = new QuestionRepository();
    }
    // получаем текущее состояние игры
    public Question getCurrentQuestion(GameState state) {
        return questionRepository
                .getQuestions()
                .get(state.getCurrentQuestionId());

    }

    public void processAnswer(
            GameState state, // состояние игры
            Question question, // текущий вопрос
            int answerIndex) { //выбранный ответ

        if (question.checkAnswer(answerIndex)) {
            state.addCorrectAnswer(); // если правильно +1
            if (state.getCurrentQuestionId()
                    == questionRepository.getQuestions().size() - 1) {
                state.finishGame(true); // если последний вопрос то победа
            } else {
                state.moveToNextQuestion();
            }
        } else {
            state.finishGame(false);
        }
    }
}
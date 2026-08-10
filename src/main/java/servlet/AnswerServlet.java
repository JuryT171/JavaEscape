package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GameState;
import model.Question;
import service.GameService;

import java.io.IOException;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    // создаем сервис для проверки для обработки ответов
    private final GameService gameService = new GameService();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // получаем сессию

        if (session == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Game not started"
            );
            return;
        }

        GameState gameState = (GameState) session.getAttribute("gameState"); // достаем объект

        if (gameState == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Game not started"
            );
            return;
        }

        int answerIndex = Integer.parseInt(request.getParameter("answerIndex")); // получаем индекс

        Question question = gameService.getCurrentQuestion(gameState); // получаем вопрос

        gameService.processAnswer( // отдаем логику gameService
                gameState,
                question,
                answerIndex
        );
        if (gameState.isFinished()) {
            gameState.getPlayer().updateBestScore(
                    gameState.getCorrectAnswers()
            );
        }

        session.setAttribute("gameState", gameState); // сохраняем в сессию

        response.setContentType("application/json"); //говорим что это json
        response.setCharacterEncoding("UTF-8");
        //формируем результат
        response.getWriter().println(
                "{\"finished\":" + gameState.isFinished() +
                        ",\"won\":" + gameState.isWon() +
                        ",\"score\":" + gameState.getCorrectAnswers() +
                        ",\"name\":\"" + gameState.getPlayer().getName() + "\"" +
                        ",\"gamesPlayed\":" + gameState.getPlayer().getGamesPlayed() +
                        ",\"bestScore\":" + gameState.getPlayer().getBestScore() +
                        "}"
        );
    }
}
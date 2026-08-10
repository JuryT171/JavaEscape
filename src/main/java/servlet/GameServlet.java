package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private final GameService gameService = new GameService(); // сосздаем сервис
    private final ObjectMapper objectMapper = new ObjectMapper(); // превращаем обьект в json

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // получаем сессию, не создаем новую

        if (session == null) { // если сессии нет, ошибка
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Game not started"
            );
            return;
        }
        // получаем gameState
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Game not started"
            );
            return;
        }

        Question question = gameService.getCurrentQuestion(gameState); // получаем вопрос

        response.setContentType("application/json");// отправляем json
        response.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(response.getWriter(), question); // превращаем question в json
    }
}
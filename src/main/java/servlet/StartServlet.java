package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GameState;
import model.Player;

import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); // получаем имя от браузера

        Player player = new Player(name);
        player.increaseGamesPlayed();

        GameState gameState = new GameState(player); // создаем игру,передаем игрока

        HttpSession session = request.getSession();

        session.setAttribute("gameState", gameState); // сохраняем сессию

        response.sendRedirect("game.html"); // переход на страницу игры
    }
}

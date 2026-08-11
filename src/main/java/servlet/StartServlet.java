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
        HttpSession session = request.getSession();
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            player = new Player(name);
        }
        player.increaseGamesPlayed();

        GameState gameState = new GameState(player); // создаем игру,передаем игрока

        session.setAttribute("player", player);

        session.setAttribute("gameState", gameState); // сохраняем сессию

        response.sendRedirect("game.html"); // переход на страницу игры
    }
}

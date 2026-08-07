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

        String name = request.getParameter("name");

        Player player = new Player(name);

        GameState gameState = new GameState(player);
        gameState.increaseGamesPlayed();

        HttpSession session = request.getSession();

        session.setAttribute("gameState", gameState);

        response.sendRedirect("game.html");
    }
}

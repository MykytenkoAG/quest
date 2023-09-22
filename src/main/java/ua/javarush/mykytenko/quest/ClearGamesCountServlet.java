package ua.javarush.mykytenko.quest;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "clearGamesCountServlet", value = "/clearGamesCount")
public class ClearGamesCountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("gamesCount", 0);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/settings.jsp");
        requestDispatcher.forward(req, resp);

    }
}
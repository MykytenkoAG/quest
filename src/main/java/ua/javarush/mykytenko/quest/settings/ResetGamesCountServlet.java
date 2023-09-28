package ua.javarush.mykytenko.quest.settings;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "clearGamesCountServlet", value = "/clearGamesCount")
public class ResetGamesCountServlet extends HttpServlet {
    private String path = "/settings.jsp";
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("gamesCount", 0);

        Cookie cookie = new Cookie("infoGamesCounterWasReset","true");
        resp.addCookie(cookie);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }
}
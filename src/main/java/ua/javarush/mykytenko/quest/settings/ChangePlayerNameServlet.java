package ua.javarush.mykytenko.quest.settings;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formsServlet", value = "/formPlayerName")
public class ChangePlayerNameServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String playerName = req.getParameterMap().get("player_name")[0];

        if(playerName!=null){
            HttpSession currentSession = req.getSession();
            currentSession.setAttribute("playerName", playerName);
        }

        Map<String, String> cookieMap =
                Arrays.stream(req.getCookies())
                        .collect(Collectors.toMap(Cookie::getName, Cookie::getValue));

        Cookie cookie;
        RequestDispatcher requestDispatcher;

        if(cookieMap.get("fromModal")!=null && cookieMap.get("fromModal").equals("true")){
            cookie = new Cookie("fromModal","false");
            resp.addCookie(cookie);
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            cookie = new Cookie("infoPlayerNameChanged","true");
            resp.addCookie(cookie);
            requestDispatcher = req.getRequestDispatcher("/settings.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

}

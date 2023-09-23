package ua.javarush.mykytenko.quest.settings;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formsServlet", value = "/formPlayerName")
public class ChangePlayerNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String playerName = req.getParameterMap().get("player_name")[0];

        if(playerName!=null){
            HttpSession currentSession = req.getSession();
            currentSession.setAttribute("playerName", playerName);
        }

        Map<String, String> cookieMap =
                Arrays.stream(req.getCookies())
                        .collect(Collectors.toMap(Cookie::getName, Cookie::getValue));

        if(cookieMap.get("fromModal")!=null && cookieMap.get("fromModal").equals("true")){
            Cookie cookie = new Cookie("fromModal","false");
            resp.addCookie(cookie);
            Cookie cookiePlayerNameChanged = new Cookie("infoPlayerNameChanged","true");
            resp.addCookie(cookiePlayerNameChanged);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            Cookie cookie = new Cookie("infoPlayerNameChanged","true");
            resp.addCookie(cookie);
            getServletContext().getRequestDispatcher("/settings.jsp").forward(req, resp);
        }

    }

}

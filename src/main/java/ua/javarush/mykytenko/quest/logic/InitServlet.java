package ua.javarush.mykytenko.quest.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.javarush.mykytenko.quest.settings.Constants;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        // Создание новой сессии
        HttpSession currentSession = req.getSession();

        // Для показа модального окна приветствия
        if(currentSession.isNew()){
            Cookie cookie = new Cookie("newQuest","true");
            resp.addCookie(cookie);
        }

        //  Считываем JSON и сохраняем дерево квеста
        File currDir = new File(req.getSession().getServletContext().getRealPath("/"));
        File rootDir = currDir.getParentFile().getParentFile();
        File file = new File(rootDir+ Constants.PATH_TO_QUEST_FILE);

        ObjectMapper objectMapper = new ObjectMapper();
        QuestTree questTree = objectMapper.readValue(file, QuestTree.class);

        //  Сохранение в сессию текущего вопроса квеста
        currentSession.setAttribute("questTree", questTree);

        //  Обновляем текст и надписи на кнопках
        QuestTree.refreshButtons(questTree, currentSession);

        //  Сохранение в сессию IP-адреса клиента
        String remoteAddr = req.getRemoteAddr();
        currentSession.setAttribute("remoteAddr", remoteAddr);

        //  Задаем имя игрока
        if(currentSession.getAttribute("playerName")==null){
            currentSession.setAttribute("playerName", "Unnamed_Player");
        }

        //  Обнуляем счетчик сыгранных игр
        if(currentSession.getAttribute("gamesCount")==null){
            currentSession.setAttribute("gamesCount", 0);
        }

        Cookie cookie = new Cookie("playerName", (String) currentSession.getAttribute("playerName"));
        resp.addCookie(cookie);

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-store");

        // Перенаправление запроса на страницу index.jsp через сервер
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
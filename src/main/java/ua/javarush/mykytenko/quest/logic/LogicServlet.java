package ua.javarush.mykytenko.quest.logic;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "logicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получаем текущую сессию
        HttpSession currentSession = req.getSession(true);

        // Получаем дерево квеста из сессии
        QuestTree questTree = extractQuestTree(currentSession);

        //  Определяем по какой кнопке произошел клик
        //  и в зависимости от этого определяем, куда по дереву следует перейти
        if(getSelectedButton(req)==1){
            if(questTree.getOption1() != null){
                questTree = questTree.getOption1();
            }
        } else if (getSelectedButton(req)==2){
            if(questTree.getOption2() != null){
                questTree = questTree.getOption2();
            }
        }

        if(questTree.getOption1()==null && questTree.getOption2()==null){
            int gamesCount = Integer.parseInt(String.valueOf(currentSession.getAttribute("gamesCount")) );
            currentSession.setAttribute("gamesCount",++gamesCount);
            if(questTree.getVictory().equals("victory")){
                Cookie cookie = new Cookie("victory","true");
                resp.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("lose","true");
                resp.addCookie(cookie);
            }
        }

        //  Сохранение в сессию текущего вопроса квеста
        currentSession.setAttribute("questTree", questTree);
        //  Обновляем тексты и видимость кнопок
        QuestTree.refreshButtons(questTree,currentSession);

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-store");

        // Перенаправление запроса на страницу index.jsp через сервер
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    private QuestTree extractQuestTree(HttpSession currentSession) {
        Object questTreeAttribute = currentSession.getAttribute("questTree");
        if (QuestTree.class != questTreeAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (QuestTree) questTreeAttribute;
    }
    private int getSelectedButton(HttpServletRequest request) {
        String buttonNumber = request.getParameter("button");
        if(buttonNumber==null){
            return 0;
        }
        boolean isNumeric = buttonNumber.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(buttonNumber) : 0;
    }

}

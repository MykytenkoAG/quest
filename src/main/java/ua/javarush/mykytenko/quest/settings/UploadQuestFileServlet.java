package ua.javarush.mykytenko.quest.settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ua.javarush.mykytenko.quest.logic.QuestTree;

@WebServlet(name = "questFileServlet", value = "/formQuestFile")
@MultipartConfig
public class UploadQuestFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part part = req.getPart("newQuestFile");

        File dir = new File(getServletContext().getRealPath("/"));
        dir = dir.getParentFile().getParentFile();
        part.write(dir+Constants.PATH_TO_NEW_QUEST_FILE);

        Path newFile = Paths.get(dir+Constants.PATH_TO_NEW_QUEST_FILE);
        Path oldFile = Paths.get(dir+Constants.PATH_TO_QUEST_FILE);

        if( validateFile(newFile.toFile()) ){
            Files.delete(oldFile);
            Files.copy(newFile,oldFile);
            Cookie cookie = new Cookie("newQuest","true");
            resp.addCookie(cookie);
            Cookie cookieQuestFileOK = new Cookie("infoQuestFileOK","true");
            resp.addCookie(cookieQuestFileOK);
        } else {
            Cookie cookie = new Cookie("questTreeFileError","true");
            resp.addCookie(cookie);
        }

        getServletContext().getRequestDispatcher("/settings.jsp").forward(req, resp);
    }

    private boolean validateFile(File file){
        try {
            //  Проверка, является ли файл корректным JSON-ом
            ObjectMapper objectMapper = new ObjectMapper();
            QuestTree questTree = objectMapper.readValue(file, QuestTree.class);

            //  Проверяем наличие необходимых узлов у корневого узла
            if(questTree.getButton1()==null || questTree.getButton2()==null || questTree.getOption1()==null || questTree.getOption2()==null){
                return false;
            }

            //  Создаем очередь
            Queue<QuestTree> questTreeQueue = new LinkedList<>();

            //  Добавляем потомков в очередь
            questTreeQueue.add(questTree.getOption1());
            questTreeQueue.add(questTree.getOption2());

            //  Проверяем всех потомков в цикле
            while (questTreeQueue.size()>0){
                //  Достаем текущий узел из очереди
                QuestTree currNode = questTreeQueue.poll();

                if(currNode==null){
                    break;
                }
                //  Достаем его потомков
                QuestTree child1 = currNode.getOption1();
                QuestTree child2 = currNode.getOption2();

                //  Если потомок всего один - файл не корректен
                if(child1==null ^ child2==null){
                    return false;
                }

                //  Если потомков нет, значит узел конечный
                //  Проверяем наличие полей "question" и "victory"
                if(child1==null && child2==null){
                    if(currNode.getQuestion()==null || currNode.getVictory()==null){
                        return false;
                    }
                    continue;
                }

                //  Если узел не конечный, проверяем наличие остальных обязательных полей
                if(currNode.getButton1()==null || currNode.getButton2()==null || currNode.getOption1()==null || currNode.getOption2()==null){
                    return false;
                }

                //  Проверяем, что потомки узла правильного класса
                if(child1.getClass()!= QuestTree.class || child2.getClass()!= QuestTree.class){
                    return false;
                }

                //  Заносим его потомков в очередь
                questTreeQueue.add(child1);
                questTreeQueue.add(child2);
            }
            return true;

        } catch (IOException e){
            return false;
        }
    }
}
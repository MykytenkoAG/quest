package ua.javarush.mykytenko.quest.settings;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;

public class Commons {
    public static final String PATH_TO_QUEST_FILE = "/src/main/resources/json/questTree.json";
    public static final String PATH_TO_NEW_QUEST_FILE = "/src/main/resources/json/questTreeNew.json";
    public static final String PATH_TO_PROLOGUE_FILE = "/src/main/resources/txt/prologue.txt";
    public static final String PATH_TO_BG_IMG_FILE = "/src/main/webapp/resources/img/background/background.jpg";
    public static File getRootDir(HttpServletRequest req){
        File currDir = new File(req.getSession().getServletContext().getRealPath("/"));
        return currDir.getParentFile().getParentFile();
    }
}

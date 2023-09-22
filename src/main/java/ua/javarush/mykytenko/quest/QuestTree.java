package ua.javarush.mykytenko.quest;

import jakarta.servlet.http.HttpSession;

public class QuestTree {
    public String getQuestion() {
        return question;
    }

    public String getButton1() {
        return button1;
    }

    public QuestTree getOption1() {
        return option1;
    }

    public String getButton2() {
        return button2;
    }

    public QuestTree getOption2() {
        return option2;
    }

    public String getVictory() {
        return victory;
    }
    public String question;
    public String button1;
    public QuestTree option1;
    public String button2;
    public QuestTree option2;
    public String victory;

    public static void refreshButtons(QuestTree questTree, HttpSession httpSession){
        //  Определение текста и видимости кнопок
        //  Если у текущего узла дерева есть потомки, обновляем значения текста и видимости
        if(questTree.getOption1()!=null){
            httpSession.setAttribute("button1Text", questTree.getButton1());
            httpSession.setAttribute("button1Visibility", "visibility: visible;");
        } else {
            httpSession.setAttribute("button1Text", "");
            httpSession.setAttribute("button1Visibility", "visibility: hidden;");
        }

        if(questTree.getOption2()!=null){
            httpSession.setAttribute("button2Text", questTree.getButton2());
            httpSession.setAttribute("button2Visibility", "visibility: visible;");
        } else {
            httpSession.setAttribute("button2Text", "");
            httpSession.setAttribute("button2Visibility","visibility: hidden;");
        }
    }
}

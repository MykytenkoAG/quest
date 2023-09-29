package ua.javarush.mykytenko.quest.settings;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "prologueFileServlet", value = "/formPrologueFile")
@MultipartConfig
public class UploadPrologueFileServlet extends HttpServlet {
    private String path = "/settings.jsp";
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Part part = req.getPart("newPrologueFile");

        part.write(Commons.getRootDir(req)+ Commons.PATH_TO_PROLOGUE_FILE);

        Cookie cookie = new Cookie("newQuest","true");
        resp.addCookie(cookie);
        Cookie cookiePrologueFileOK = new Cookie("infoPrologueFileOK","true");
        resp.addCookie(cookiePrologueFileOK);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String prologueFileName = Commons.getRootDir(req)+ Commons.PATH_TO_PROLOGUE_FILE;

        // Set the content type and header of the response.
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();

        try (BufferedReader reader = new BufferedReader(new FileReader(prologueFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line + "\n");
            }
        }
    }
}
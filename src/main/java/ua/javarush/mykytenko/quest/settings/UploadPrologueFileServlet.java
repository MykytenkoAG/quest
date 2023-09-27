package ua.javarush.mykytenko.quest.settings;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "prologueFileServlet", value = "/formPrologueFile")
@MultipartConfig
public class UploadPrologueFileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Part part = req.getPart("newPrologueFile");

        File currDir = new File(req.getSession().getServletContext().getRealPath("/"));
        File rootDir = currDir.getParentFile().getParentFile();
        part.write(rootDir+Constants.PATH_TO_PROLOGUE_FILE);

        Cookie cookie = new Cookie("newQuest","true");
        resp.addCookie(cookie);
        Cookie cookiePrologueFileOK = new Cookie("infoPrologueFileOK","true");
        resp.addCookie(cookiePrologueFileOK);

        getServletContext().getRequestDispatcher("/settings.jsp").forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        File currDir = new File(req.getSession().getServletContext().getRealPath("/"));
        File rootDir = currDir.getParentFile().getParentFile();
        String prologueFileName = rootDir+Constants.PATH_TO_PROLOGUE_FILE;

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
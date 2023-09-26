package ua.javarush.mykytenko.quest.settings;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "downloadServlet", value = "/downloadExample")
public class DownloadQuestFileServlet extends HttpServlet {
    private final int ARBITRARY_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition", "attachment; filename=questTree.json");

        File dir = new File(getServletContext().getRealPath("/"));
        dir = dir.getParentFile().getParentFile();
        File file = new File(dir+Constants.PATH_TO_QUEST_FILE);

        try(InputStream in = new FileInputStream(file);
            OutputStream out = resp.getOutputStream()) {

            byte[] buffer = new byte[ARBITRARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
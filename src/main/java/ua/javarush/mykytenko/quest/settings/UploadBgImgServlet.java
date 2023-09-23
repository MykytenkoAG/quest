package ua.javarush.mykytenko.quest.settings;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet(name = "backgroundImgServlet", value = "/formBackgroundImg")
@MultipartConfig
public class UploadBgImgServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Part part = req.getPart("newBackgroundImg");

        File dir = new File(getServletContext().getRealPath("/"));
        dir = dir.getParentFile().getParentFile();
        part.write(dir+"/src/main/webapp/img/background/background.jpg");

        getServletContext().getRequestDispatcher("/settings.jsp").forward(req, resp);

    }
}
package ua.javarush.mykytenko.quest.settings;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet(name = "backgroundImgServlet", value = "/formBackgroundImg")
@MultipartConfig
public class UploadBgImgServlet extends HttpServlet {
    private String path = "/settings.jsp";
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Part part = req.getPart("newBackgroundImg");

        part.write(Commons.getRootDir(req)+ Commons.PATH_TO_BG_IMG_FILE);

        Cookie cookie = new Cookie("infoBgImgOK","true");
        resp.addCookie(cookie);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }
}
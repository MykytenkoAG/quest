import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.PrintWriter;

import ua.javarush.mykytenko.quest.settings.UploadPrologueFileServlet;

import static org.mockito.Mockito.*;

public class UploadPrologueFileServletTest {
    private final static String path = "/settings.jsp";
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    ServletConfig servletConfig;
    @Mock
    ServletContext servletContext;
    @Mock
    ServletOutputStream outputStream;
    @Mock
    PrintWriter responseWriter;
    @Mock
    Part part;
    UploadPrologueFileServlet servlet;
    @Test
    public void testDoGet() throws Exception{

        servlet = new UploadPrologueFileServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);
        outputStream = mock(ServletOutputStream.class);
        responseWriter = mock(PrintWriter.class);

        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);
        String currDir = InitServletTest.class.getResource("InitServletTest.class").toString()
                .replaceAll("file:/", "")
                .replaceAll("/target/test-classes/InitServletTest.class", "/src/main/");
        when(servletContext.getRealPath("/")).thenReturn(currDir);
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(response.getOutputStream()).thenReturn(outputStream);
        when(response.getWriter()).thenReturn(responseWriter);

        servlet.doGet(request,response);

    }
    @Test
    public void testDoPost() throws Exception{

        servlet = new UploadPrologueFileServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);
        outputStream = mock(ServletOutputStream.class);
        responseWriter = mock(PrintWriter.class);
        part = mock(Part.class);

        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);
        String currDir = InitServletTest.class.getResource("InitServletTest.class").toString()
                .replaceAll("file:/", "")
                .replaceAll("/target/test-classes/InitServletTest.class", "/src/main/");
        when(servletContext.getRealPath("/")).thenReturn(currDir);
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        when(response.getOutputStream()).thenReturn(outputStream);
        when(response.getWriter()).thenReturn(responseWriter);
        when(request.getPart("newPrologueFile")).thenReturn(part);

        servlet.doPost(request,response);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);

    }
}
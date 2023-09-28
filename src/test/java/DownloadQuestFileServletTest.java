import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.javarush.mykytenko.quest.settings.DownloadQuestFileServlet;

import static org.mockito.Mockito.*;

public class DownloadQuestFileServletTest {
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
    DownloadQuestFileServlet servlet;
    @Test
    public void testDoGet() throws Exception{

        servlet = new DownloadQuestFileServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);
        outputStream = mock(ServletOutputStream.class);

        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);
        String currDir = InitServletTest.class.getResource("InitServletTest.class").toString()
                .replaceAll("file:/", "")
                .replaceAll("/target/test-classes/InitServletTest.class", "/src/main/");
        when(servletContext.getRealPath("/")).thenReturn(currDir);
        when(response.getOutputStream()).thenReturn(outputStream);

        servlet.doGet(request,response);

    }
}
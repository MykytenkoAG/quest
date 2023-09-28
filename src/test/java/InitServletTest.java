import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.javarush.mykytenko.quest.logic.InitServlet;

import static org.mockito.Mockito.*;

public class InitServletTest {
    private final static String path = "/index.jsp";
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
    InitServlet servlet;

    @Test
    public void testDoGet() throws Exception{

        servlet = new InitServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);

        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);
        String currDir = InitServletTest.class.getResource("InitServletTest.class").toString()
                .replaceAll("file:/", "")
                .replaceAll("/target/test-classes/InitServletTest.class", "/src/main/");
        when(servletContext.getRealPath("/")).thenReturn(currDir);
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);

    }
}
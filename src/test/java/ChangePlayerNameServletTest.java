import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.Map;

import ua.javarush.mykytenko.quest.settings.ChangePlayerNameServlet;

import static org.mockito.Mockito.*;

public class ChangePlayerNameServletTest {
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
    Map<String,String[]> parameterMap;
    ChangePlayerNameServlet servlet;
    @Test
    public void testDoPost() throws Exception{

        servlet = new ChangePlayerNameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);
        parameterMap = mock(Map.class);

        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);
        when(request.getParameterMap()).thenReturn(parameterMap);
        when(parameterMap.get("player_name")).thenReturn(new String[]{"player_name"});
        when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("fromModal","false")});
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doPost(request,response);

        verify(request, times(1)).getParameterMap();
        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);

    }
}
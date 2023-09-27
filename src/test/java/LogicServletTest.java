import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.javarush.mykytenko.quest.logic.InitServlet;
import ua.javarush.mykytenko.quest.logic.LogicServlet;
import ua.javarush.mykytenko.quest.logic.QuestTree;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogicServletTest {
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
    LogicServlet servlet;
    @Test
    public void testDoGet() throws Exception{

        servlet = new LogicServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock(ServletConfig.class);
        servletContext = mock(ServletContext.class);

        when(request.getSession(true)).thenReturn(session);
        when(session.getServletContext()).thenReturn(servletContext);

        QuestTree questTreeAttribute = mock(QuestTree.class);
        when(session.getAttribute("questTree")).thenReturn(questTreeAttribute);
        when(session.getAttribute("gamesCount")).thenReturn("0");
        when(questTreeAttribute.getVictory()).thenReturn("victory");

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        servlet.doGet(request,response);

    }
}
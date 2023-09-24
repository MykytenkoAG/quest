import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ua.javarush.mykytenko.quest.logic.InitServlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Before
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testDoGet() throws Exception{

        servlet = new InitServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        servletConfig = mock( ServletConfig.class );
        servletContext = mock( ServletContext.class );

        when(request.getSession()).thenReturn(session);
        when(servlet.getServletConfig()).thenReturn( servletConfig );
        when(servletConfig.getServletContext()).thenReturn( servletContext );

        servlet.doGet(request, response);

    }

}

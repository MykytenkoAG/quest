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
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        dispatcher = Mockito.mock(RequestDispatcher.class);
        session = Mockito.mock(HttpSession.class);
        servletConfig = Mockito.mock( ServletConfig.class );
        servletContext = Mockito.mock( ServletContext.class );

        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(servlet.getServletConfig()).thenReturn( servletConfig );
        Mockito.when(servletConfig.getServletContext()).thenReturn( servletContext );

        servlet.doGet(request, response);

    }

}

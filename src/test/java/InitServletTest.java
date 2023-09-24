import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mockit.Mocked;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import ua.javarush.mykytenko.quest.logic.InitServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
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

    @Before
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testDoGet() throws Exception{

        InitServlet servlet = new InitServlet();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        dispatcher = Mockito.mock(RequestDispatcher.class);
        session = Mockito.mock(HttpSession.class);

        Mockito.when(request.getSession()).thenReturn(session);

        ServletConfig sc = Mockito.mock( ServletConfig.class );
        ServletContext ctx = Mockito.mock( ServletContext.class );

        //Mockito.when( servlet.getServletConfig()).thenReturn( sc );
        //Mockito.when( sc.getServletContext()).thenReturn( ctx );

        servlet.doGet(request, response);

    }


}

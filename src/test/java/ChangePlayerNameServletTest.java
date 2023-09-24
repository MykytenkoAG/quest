import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ua.javarush.mykytenko.quest.settings.ChangePlayerNameServlet;
import ua.javarush.mykytenko.quest.settings.ResetGamesCountServlet;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class ChangePlayerNameServletTest {
    private final static String path = "/settings.jsp";
    @Mock
    private String[] stringList;
    @Test
    public void testDoPost() throws Exception{

/*        final ChangePlayerNameServlet servlet = new ChangePlayerNameServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        HashMap<String,String[]> parameterMap = mock(HashMap.class);

        when(request.getParameterMap()).thenReturn( parameterMap );

        Object key = mock(Object.class);
        when(request.getParameterMap().get(key)).thenReturn(stringList);*/


    }
}

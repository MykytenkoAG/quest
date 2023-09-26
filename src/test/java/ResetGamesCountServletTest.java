import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import ua.javarush.mykytenko.quest.settings.ResetGamesCountServlet;

import static org.mockito.Mockito.*;

public class ResetGamesCountServletTest {
    private final static String path = "/settings.jsp";
    @Test
    public void testDoPost() throws Exception{
        final ResetGamesCountServlet servlet = new ResetGamesCountServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    }
}
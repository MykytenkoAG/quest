import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

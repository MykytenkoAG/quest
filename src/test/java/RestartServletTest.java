import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import ua.javarush.mykytenko.quest.logic.RestartServlet;

import static org.mockito.Mockito.mock;

public class RestartServletTest {
    @Test
    public void testDoGet() throws Exception{
        final RestartServlet servlet = new RestartServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    }
    @Test
    public void testDoPost() throws Exception{
        final RestartServlet servlet = new RestartServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    }
}
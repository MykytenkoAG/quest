import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import ua.javarush.mykytenko.quest.settings.UploadPrologueFileServlet;

import static org.mockito.Mockito.mock;

public class UploadPrologueFileServletTest {
    @Test
    public void testDoGet() throws Exception{
        final UploadPrologueFileServlet servlet = new UploadPrologueFileServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    }
    @Test
    public void testDoPost() throws Exception{
        final UploadPrologueFileServlet servlet = new UploadPrologueFileServlet();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    }
}
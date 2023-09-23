import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import ua.javarush.mykytenko.quest.settings.ResetGamesCountServlet;
import ua.javarush.mykytenko.quest.settings.UploadBgImgServlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UploadBgImgServletTest {

    @Test
    public void testDoPost() throws Exception{

        final UploadBgImgServlet servlet = new UploadBgImgServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

    }
}

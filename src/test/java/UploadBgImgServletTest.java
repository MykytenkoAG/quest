import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import ua.javarush.mykytenko.quest.settings.UploadBgImgServlet;

import static org.mockito.Mockito.mock;

public class UploadBgImgServletTest {

    @Test
    public void testDoPost() throws Exception{

        final UploadBgImgServlet servlet = new UploadBgImgServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);

    }
}

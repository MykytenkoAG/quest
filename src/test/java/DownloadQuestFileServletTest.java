import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import ua.javarush.mykytenko.quest.settings.ResetGamesCountServlet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DownloadQuestFileServletTest {
    private final static String path = "/settings.jsp";
    @Test
    public void testDoPost() throws Exception{

        ServletConfig sc = mock( ServletConfig.class );
        ServletContext ctx = mock( ServletContext.class );
        when( sc.getServletContext()).thenReturn( ctx );

        ResetGamesCountServlet clearGamesCountServlet = new ResetGamesCountServlet();
        clearGamesCountServlet.init( sc );

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession httpSession = mock(HttpSession.class);

        when(request.getSession()).thenReturn(httpSession);
        when(ctx.getRequestDispatcher(path)).thenReturn(dispatcher);

/*        clearGamesCountServlet.doPost(request, response);
        verify(dispatcher).forward(request, response);*/

    }
}

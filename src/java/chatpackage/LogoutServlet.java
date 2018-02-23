package chatpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ghada
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    UserDao user = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("userName");
        String password = (String) request.getSession().getAttribute("password");

        for(int i=0;i<LogupServlet.users.size();i++){
            if (LogupServlet.users.get(i).getUserName().equals(name) && LogupServlet.users.get(i).getPassword().equals(password)) {
                LogupServlet.users.get(i).setMyStatus("offline");
                response.sendRedirect("Login.jsp");
                request.getSession(false).invalidate();
            }
        }
        
    }

}

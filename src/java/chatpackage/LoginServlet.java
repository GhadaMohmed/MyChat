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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    UserDao user = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isUserExist = false;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        for (int i = 0; i < LogupServlet.users.size(); i++) {
            if (LogupServlet.users.get(i).getUserName().equalsIgnoreCase(userName) && LogupServlet.users.get(i).getPassword().equals(password)) {
                isUserExist = true;
                request.getSession(true).setAttribute("userName", userName);
                request.getSession(true).setAttribute("password", password);
                LogupServlet.users.get(i).setMyStatus("online");
                response.sendRedirect("Home.jsp");
            }
        }

        if (!isUserExist) {
            response.sendRedirect("Logup.jsp");
        }

    }
}

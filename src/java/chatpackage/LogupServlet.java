package chatpackage;

import static chatpackage.ChatServlet.myMsg;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ghada
 */
@WebServlet(name = "LogupServlet", urlPatterns = {"/LogupServlet"})
public class LogupServlet extends HttpServlet {

    boolean isUserExist = false;
    public static List<UserDao> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao user = new UserDao();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        for (UserDao myUser : users) {
            if (myUser.getUserName().equalsIgnoreCase(userName)) {
                isUserExist = true;
            }
        }
        if (!isUserExist) {
            users.add(user);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("application/json");
//        Gson msgGson = new Gson();
//        PrintWriter out = response.getWriter();
//        out.write(msgGson.toJson(users));
//    }

}

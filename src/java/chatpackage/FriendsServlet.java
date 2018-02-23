package chatpackage;

import static chatpackage.ChatServlet.myMsg;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ghada
 */
@WebServlet(name = "FriendsServlet", urlPatterns = {"/FriendsServlet"})
public class FriendsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson msgGson = new Gson();
        PrintWriter out = response.getWriter();
        out.write(msgGson.toJson(LogupServlet.users));
    }

}

package chatpackage;

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
@WebServlet(name = "ChatServlet", urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

    public static List<MsgDao> myMsg = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = (String) request.getSession(false).getAttribute("userName");
        String msg = request.getParameter("message");
        MsgDao userMsg = new MsgDao();
        userMsg.setName(name);
        userMsg.setMsg(msg);
        myMsg.add(userMsg);

        System.out.println(name);
        System.out.println(msg);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson msgGson = new Gson();
        System.out.println(myMsg.size());
        PrintWriter out = response.getWriter();
        out.write(msgGson.toJson(myMsg));
    }

}

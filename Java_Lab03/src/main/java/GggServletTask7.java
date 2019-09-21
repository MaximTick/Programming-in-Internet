import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetServlet")
public class GggServletTask7 extends HttpServlet implements Servlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("group");
        String press = req.getParameter("press");
        HttpClient hc = new HttpClient();
        GetMethod gm;
        String uri = "http://localhost:8080" + req.getContextPath();

        if (press.equalsIgnoreCase("SignUp")) {
            String parmstr = "username=" + username + "&"
                    + "password=" + password;

            if (sex.equalsIgnoreCase("male"))
                uri += "/Out?" + parmstr;
        }
        else
            uri += "/index.html";
        hc.executeMethod(gm = new GetMethod(uri));
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }
}

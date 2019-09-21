import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Ggg")
public class GggServlet extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //task 4 закоменть   для 1 таска
      /*  String path = "/starting.html";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req,resp);
        System.out.println("Forward to Html page")*/;
        //-----------------------------------------//

        String parm1 = req.getParameter("username");
        String parm2 = req.getParameter("password");
        System.out.println("Ggg:doGet:username=" + parm1);
        System.out.println("Ggg:doGet:password=" + parm2);

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>"
                + "Hello from Servlet"
                + "<br>Ggg:doGet: username=" + parm1
                + "<br>Ggg:doGet: password=" + parm2
                + "<br>Ggg:getRemoteHost: " + req.getRemoteHost()
                + "<br>Ggg:getServletPath: " + req.getServletPath()
                + "<br>Ggg:getServerName: " + req.getServerName()
                + "<br>Ggg:rq.getContextPath: " + req.getContextPath()
                + "<br>Ggg:getServletName: " + this.getServletName()
                + "</body></html>");
        pw.close();
    }
}

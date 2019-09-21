import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SssServlet extends HttpServlet implements Servlet {
    //task 1 & 4 для первого таска в Ggg коменть перенаправление на html
    //Хочешь чтобы работал doGet - закоменть service
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path = "/Ggg?username=crazy&password=f*uck"; //а еще это task 7
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req,resp);
        System.out.println("Forward to GggServlet");
    }
    //task 2
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Simple PostHandler in service method");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("group");
        String press = req.getParameter("press");

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>firstname=" + username
                + "<br>password= " + password
                + "<br>sex= " + sex
                + "<br>press= " + press
                + "</body>" + "</html>");
        pw.close();
    }
}


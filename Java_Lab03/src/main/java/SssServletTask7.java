import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Sss7")
public class SssServletTask7 extends HttpServlet implements Servlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8080"
                + req.getContextPath() + "/GetServlet?press=SignUp");
        //task 8
        /*PostMethod postMethod = new PostMethod("http://192.168.0.102:8080"
                + "/Java3" + "/GetServlet?press=SignUp");*/
        NameValuePair[] parametrs = {
                new NameValuePair("username", "Maximka"),
                new NameValuePair("password", "shitshit"),
                new NameValuePair("group", "male")};
        postMethod.addParameters(parametrs);
        httpClient.executeMethod(postMethod);
        if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
            System.out.println("200 OK! ZAEBUMBA!!!");
            InOutServlet inout = new InOutServlet(resp.getOutputStream(),
                    postMethod.getResponseBodyAsStream());
            inout.perform();
        } else {
            System.out.println("Sss:service:getStatusCode()="
                    + postMethod.getStatusCode());
        }
    }
}




package log4j;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "loginServlet", value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String userName = req.getParameter("uname");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        if(userName.equals("admin") && password.equals("password")){
            out.println("Welcome Back Admin IHS");
        }
        else{

            // vulnerable code
            Logger logger = LogManager.getLogger();
            logger.error(userName);

            out.println("<code> the password you entered was invalid, <u> we will log your information </u> </code>");
        }
    }

    public void destroy() {
    }
}
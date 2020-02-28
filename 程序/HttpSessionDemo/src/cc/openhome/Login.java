package cc.openhome;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        if("CKB".equals(user) && "201711045".equals(passwd)) {
            request.getSession().setAttribute("login", user);
            request.getRequestDispatcher("function.jsp")
                    .forward(request, response);
        }
        else {
            response.sendRedirect("login.html");
        }
    }
}

package cc.openhome;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Count extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            int count = 0;
            HttpSession session = request.getSession();
            if(session.getAttribute("count") != null) {
                Integer c = (Integer) session.getAttribute("count");
                count = c.intValue() + 1;
            }
            session.setAttribute("count", new Integer(count));
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Count</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Count " + count + "</h1>");
            out.println("<a href=\""+
                    response.encodeURL("count.do")+ "\">递增</a>");
            out.println("</body>");
            out.println("</html>");
            out.close();
    } 
}

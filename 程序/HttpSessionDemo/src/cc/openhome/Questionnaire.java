package cc.openhome;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Questionnaire extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Questionnaire</title>");
        out.println("</head>");
        out.println("<body>");
        String page = request.getParameter("page");

        out.println("<form action=\"question.do\" method=\"post\">");
        if("page1".equals(page)) {
            out.println("问题一：<input type=\"text\" name=\"p1q1\"><br>");
            out.println("问题二：<input type=\"text\" name=\"p1q2\"><br>");
            out.println("<input type=\"submit\" name=\"page\" value=\"page2\">");
        }
        else if("page2".equals(page)) {
            String p1q1 = request.getParameter("p1q1");
            String p1q2 = request.getParameter("p1q2");
            HttpSession session = request.getSession();
            session.setAttribute("p1q1", p1q1);
            session.setAttribute("p1q2", p1q2);
            out.println("问题三：<input type=\"text\" name=\"p2q1\"><br>");
            out.println("<input type=\"submit\" name=\"page\" value=\"finish\">");
        }
        else if("finish".equals(page)) {
            HttpSession session = request.getSession();
            out.println(session.getAttribute("p1q1") + "<br>");
            out.println(session.getAttribute("p1q2") + "<br>");
            out.println(request.getParameter("p2q1") + "<br>");
        }
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

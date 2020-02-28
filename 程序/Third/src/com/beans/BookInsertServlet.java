package com.beans;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.beans.BookBean;
import com.beans.BookDAO;

public class BookInsertServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String message = null;
        BookBean book = new BookBean(
            request.getParameter("bookid"),request.getParameter("title"),
            request.getParameter("author"),request.getParameter("publisher"),
            Float.parseFloat(request.getParameter("price"))
            );
        BookDAO bookdao = new BookDAO();
        boolean success = bookdao.insertBook(book);
        if(success){
           message = "成功插入一条记录！";
         }else{ 
           message = "插入记录错误！";
        }   
       request.setAttribute("result",message);
       RequestDispatcher view = request.getRequestDispatcher("/bookInsert.jsp");
       view.forward(request, response);
    }
}
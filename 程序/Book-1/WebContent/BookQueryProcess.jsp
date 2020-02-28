<%@ page language="java" import="com.beans.*" contentType="text/html; charset=utf-8"%>
<%
String bookid=request.getParameter("bookid");
BookBean bookbean=new BookDAO().searchBook(bookid);
String url1 = "display.jsp";
String url2 = "errorPage.jsp";
request.setAttribute("book", bookbean);
RequestDispatcher dis;
if(bookbean!=null)
{
	dis = request.getRequestDispatcher(url1);
	dis.forward(request, response);
}
else
{
	dis = request.getRequestDispatcher(url2);
	dis.forward(request, response);	
}
%>

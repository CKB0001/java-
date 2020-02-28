<%@ page language="java" import="com.beans.*"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String bookid=request.getParameter("bookid");
String title=request.getParameter("title");
String author=request.getParameter("author");
String publisher=request.getParameter("publisher");
float price=Float.valueOf(request.getParameter("price"));
BookBean book1=new BookBean();
BookDAO ckb=new BookDAO();
book1.setBookid(bookid);
book1.setAuthor(author);
book1.setPrice(price);
book1.setPublisher(publisher);
book1.setTitle(title);
ckb.insertBook(book1);
RequestDispatcher dis;
String url1 = "displayBooks.jsp";
dis = request.getRequestDispatcher(url1);
dis.forward(request, response);
%>

</body>
</html>
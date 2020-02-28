<%@ page language="java" import="edu.lzjtu.dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String username= request.getParameter("username");
String pwd = request.getParameter("pwd");
boolean flag = new UserDAO().exist(username,pwd);

RequestDispatcher dis;
String url1="main.jsp";
String url2="error.jsp";

if(flag){
	dis = request.getRequestDispatcher(url1);
	dis.forward(request,response);
}
else{
	dis = request.getRequestDispatcher(url2);
	dis.forward(request,response);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
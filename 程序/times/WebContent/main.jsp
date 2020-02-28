<%@ page language="java" import="java.util.*, edu.lzjtu.entity.*, edu.lzjtu.dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style>
	  body{font-size:28px;}
  div{font-size:28px}
    input{font-size:28px}
  </style>
</head>
<body>
通讯录列表  <br>

<%
List<Phonebook> list=null;
list = new PhonebookDAO().getList();
if(list!=null){
	out.println(list.size());
}
%>  <br>

<a href="insert.jsp">录入新的联系人</a>
  <br>

 <table border="1">

  <%

if(list!=null){
	//out.println(list.size());
	for(int i=0;i<list.size();i++){
	Phonebook o=list.get(i);
	out.print("<tr>");
	out.print("<td>");
	out.print(o.getId());
	out.print("</td>");

	out.print("<td>");
	out.print(o.getName());
	out.print("</td>");
	out.print("<td>");
	out.print(o.getPhonenumber());
	out.print("</td>");
	out.print("<td>");
	out.print("<a href=''>edit</a>&nbsp;&nbsp;&nbsp;");
	out.print("<a href=''>delete</a>");
	out.print("</td>");
	out.print("<tr>");
	}
}
%>
  
  </table>
</body>
</html>
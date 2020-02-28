<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>请输入您要删除的信息：</h3>
<% if(request.getAttribute("result")!=null){
%>
<h3><font color="#FF0000">删除成功！</font></h3>
<%
}
%>
<form action="DeleteCustomerServlet" method="post">
	<fieldset>姓名&emsp;&emsp;&emsp;<input placeholder="输入姓名" type="text" name="name"></fieldset>
	<fieldset>身份证号&emsp;<input placeholder="输入身份证号" type="text" name="idcard">(二选一)</fieldset>
	<fieldset>
	    <input type="submit" id="contact-submit" value="提交" >
		<input name="pclog" type="button" align="middle" value="刷新" onClick="location.href='delete.jsp'">
		<input name="pclog" type="button" align="middle" value="返回" onClick="location.href='login.jsp'">
	</fieldset>
</form>
</body>
</html>
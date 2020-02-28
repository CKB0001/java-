<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>请输入您要添加的信息：</h3>
<%-- <%
	if(request.getAttribute("result")!=null){
		out.print(request.getAttribute("result"));
	}
%> --%>
<% if(request.getAttribute("result")!=null){
%>
<h3><font color="#FF0000">添加成功！</font></h3>
<%
}
%>
<form action="AddCustomerServlet" method="post">
	<fieldset>编号&emsp;&emsp;&emsp;<input placeholder="输入编号" type="text" name="cid" tabindex="1" required autofocus></fieldset>
    <fieldset>姓名&emsp;&emsp;&emsp;<input placeholder="输入姓名" type="text" name="cname" tabindex="2" required></fieldset>      
    <fieldset>性别&emsp;&emsp;&emsp;<input placeholder="输入性别" type="text" name="csex" tabindex="3" required></fieldset> 
    <fieldset>出生日期&emsp;<input placeholder="输入出生日期" type="text" name="cbirthday" tabindex="4" required></fieldset>
    <fieldset>身份证号&emsp;<input placeholder="输入身份证号" type="text" name="cidcard" tabindex="5" required></fieldset>
    <fieldset>家庭地址&emsp;<input placeholder="输入家庭地址" type="text" name="caddress" tabindex="6" required></fieldset>
    <fieldset>联系电话&emsp;<input placeholder="输入联系方式" type="text" name="cphone" tabindex="7" required></fieldset>
    <fieldset><input type="submit" id="contact-submit" value="确定" >
      		  <input type="reset" value="重置" >
      		  <input name="pclog" type="button" align="middle" value="刷新" onClick="location.href='add.jsp'">
      		  <input name="pclog" type="button" align="middle" value="返回" onClick="location.href='login.jsp'">
      	      </fieldset>	
</form>

</body>
</html>
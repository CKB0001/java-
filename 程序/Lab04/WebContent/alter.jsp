<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<h3>请输入您要修改的信息：（请输入全部的值）</h3>
<% if(request.getAttribute("result")!=null){
%>
<h3><font color="#FF0000">修改成功！</font></h3>
<%
}
%>
<body>
<form action="AlterCustomerServlet" method="post">
	<fieldset>编号&emsp;&emsp;&emsp;<input placeholder="输入编号" type="text" name="cid" ></fieldset>
    <fieldset>姓名&emsp;&emsp;&emsp;<input placeholder="输入姓名" type="text" name="cname"></fieldset>      
    <fieldset>性别&emsp;&emsp;&emsp;<input placeholder="输入性别" type="text" name="csex"></fieldset> 
    <fieldset>出生日期&emsp;<input placeholder="输入出生日期" type="text" name="cbirthday"></fieldset>
    <fieldset>身份证号&emsp;<input placeholder="输入身份证号" type="text" name="cidcard"></fieldset>
    <fieldset>家庭地址&emsp;<input placeholder="输入家庭地址" type="text" name="caddress"></fieldset>
    <fieldset>联系电话&emsp;<input placeholder="输入联系方式" type="text" name="cphone"></fieldset>
    <fieldset><input type="submit" id="contact-submit" value="确定" >
      		  <input type="reset" value="重置" >
      		  <input name="pclog" type="button" align="middle" value="刷新" onClick="location.href='alter.jsp'">
      		  <input name="pclog" type="button" align="middle" value="返回" onClick="location.href='login.jsp'">
      	      </fieldset>	
</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
  <head>    
    <title>注册成功！</title>	
  </head>  
  <body >
    <h3>恭喜，${user.userRealName},你成功注册了我们的管理系统！点此
       <a href="<%=basePath%>user/login.jsp">登录</a>
    </h3>
  </body>
</html>

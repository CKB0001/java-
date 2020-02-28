<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
       欢迎你，${user.userRealName} ，你登入成功！！<br>
       进入名片管理系统，请点击<a href="<%=basePath%>card/find">名片管理系统</a>。。。   
</body>
</html>

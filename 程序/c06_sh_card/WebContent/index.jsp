<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>主界面</title>
</head>
<body>
	<h1>名片管理系统</h1>
	<div>
		<a href="<%=basePath%>user/login.jsp">用户管理子系统</a><br><br>
	</div>
	<div>
		<a href="<%=basePath%>card/find">名片管理子系统</a>
	</div>
</body>
</html>

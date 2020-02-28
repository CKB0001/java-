<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/login.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login.js"></script>
	  <style>
  div{font-size:28px}
    input{font-size:28px}
  </style>
</head>
<body>
	<div class="loginwarrp">
		<div class="logo">管理员登陆</div>
		<div class="login_form">
			<form method="post" onsubmit="return checkAll()"
			action="${pageContext.request.contextPath}/DoLoginServlet">
				<li class="login-item"><span>用户名：</span> <input type="text" placeholder="   Input your name"
					id="username" name="UserName" class="login_input"
					onfocus="onfocus()"><span id="count-msg" class="error"></span></li>
				<li class="login-item"><span>密 码：</span> <input type="password" placeholder="     Input your password"
					id="password" name="password" class="login_input"
					onfocus="onfocus()"><span id="password-msg" class="error"></span></li>

				<li class="login-sub"><input type="submit" name="Submit"
					value="登录" /> <input type="button" id="register" value="注册"/></li>
		</form>
	</div>
	</div>
           <div class="msg"><span>${requestScope.msg}</span></div>
</body>
</html>
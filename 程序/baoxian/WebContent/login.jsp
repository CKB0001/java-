<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>浩哥保险业务系统 - 用户登录</title>
		<meta name="keywords" content="">
	    <meta name="description" content="">
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="css/animate.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">
	    <link href="css/login.css" rel="stylesheet">
	    <!--[if lt IE 9]>
	    <meta http-equiv="refresh" content="0;ie.html" />
	    <![endif]-->
	    <script>
	        if (window.top !== window.self) {
	            window.top.location = window.location;
	        }
	    </script>
	</head>
	<body class="signin">
		<%
			String errorInfo = (String)request.getAttribute("errorInfo");
		%>
	    <div class="signinpanel">
	        <div class="row">
		        <div class="col-sm-12">
		            <div class="pull-left" style="font-size:21px;">
		                	<font color="black">--------<i class="fa fa-heart"></i>浩哥保险业务系统
		            --------</font></div>
		        </div>
	            <div class="col-sm-12 signup-footer">
	                <form method="post" action="EmpLoginServlet">
	                    <h4 class="no-margins"><font color="black"> 用户登录：</font></h4>
	                    <input id="loginId" name="loginId" type="text" class="form-control uname" placeholder="用户名"  />
	                    <input id="loginPwd" name="loginPwd" type="password" class="form-control pword m-b" placeholder="密码" />
	                    <label>
	                    	<input type="checkbox" checked="checked" />
	                    	<span style="color: #333333;">记住登录状态</span>
	                    </label>
	                    <%if(errorInfo!=null){ %>
	                    <div style="text-align:center;color:red;font-size:14px;"><%=errorInfo%></div>
	                    <%} %>
	                    <tr>
	                    <td><button type="submit" class="btn btn-success btn-block">登录</button></td>
	                    <td><a href="register.jsp" class="btn btn-success btn-block btn-info" role="button">注册</button></a></td></tr>
	                </form>
	            </div>
	        </div>
	    </div>
	</body>
</html>
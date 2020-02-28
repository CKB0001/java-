<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>浩哥保险业务系统 - 用户注册</title>
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
	                <form method="post" action="RegisterServlet">
	                    <h3 class="no-margins"><font color="black"> 用户注册：</font></h3>
	                    <input id="" name="user" type="text" class="form-control" placeholder="请输入用户名"  />
	                    <input id="" name="passwd" type="password" class="form-control" placeholder="请输入密码" />
	                    <input id="" name="realname" type="text" class="form-control" placeholder="请输入真实姓名"  />
	                    <input id="" name="idcard" type="text" class="form-control" placeholder="请输入身份证号"  />
	                    <input id="" name="phone" type="text" class="form-control" placeholder="请输入电话号码" />
	                    <input id="" name="address" type="text" class="form-control" placeholder="请输入家庭住址"  />
	                    
	                    <%if(errorInfo!=null){ %>
	                    <div style="text-align:center;color:red;font-size:14px;"><%=errorInfo%></div>
	                    <%} %>
	                    <button type="submit" class="btn btn-success btn-block">点击注册</button>
	                    <button type="reset" class="btn btn-success btn-block">重置</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</body>
</html>
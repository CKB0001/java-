<%@ page language="java" contentType="text/html; charset=utf-8"%>
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
	href="${pageContext.request.contextPath}/style/main.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/table.css">
<script type="text/javascript"></script>

<script type="text/javascript">
	window.onload = function() {
		var na = "${a}";
		var phon = "${b}";
		var q = "${c}";
		var add = "${d}";

		document.getElementById("name").value = na;
		document.getElementById("phone").value = phon;
		document.getElementById("address").value = add;
		document.getElementById("qq").value = q;

	}
</script>
	  <style>
	  button{font-size:28px}
  div{font-size:28px}
    input{font-size:28px}
  </style>
</head>
<body>
	<div class="menu">
		<div class="title"><span class="sp">管理员:<strong>&nbsp;&nbsp;&nbsp;${username}</strong></span></div>

		<div class="cont">
			<ul class="mlist">
				<li>
					<h4>
						<span>-人员管理</span>
					</h4>

					<dl>
						<dd>
							<a href="${pageContext.request.contextPath}/RefreshItems">人员列表</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath}/jsps/additems.jsp">新增人员</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath}/jsps/AddItems.jsp">退出登陆</a>
						</dd>
					</dl>
				</li>

			</ul>
	</div>

	</div>


	<div class="left_content">
		<div class="left_item"><span>&nbsp;&nbsp;&nbsp;请修改你的好友</span></div>
	</div>

	<div class="container">
		<form align="center" id="contact"
		action="${pageContext.request.contextPath}/UpdataItemsById?id=${e}"
		method="post">

			<fieldset>

				<input type="text" id="name" name="name" tabindex="1" required
					autofocus>
			</fieldset>
			<fieldset>
				<input type="text" id="phone" name="phone" tabindex="2" required>
			</fieldset>
			<fieldset>
				<input type="text" id="address" name="address" tabindex="3" required>
			</fieldset>
			<fieldset>
				<input type="text" id="qq" name="qq" tabindex="4" required>
			</fieldset>

			<fieldset>
				<button name="submit" type="submit" id="contact-submit">确认修改</button>
			</fieldset>
	</form>

	</div>


</body>
</html>
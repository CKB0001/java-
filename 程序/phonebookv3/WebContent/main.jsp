<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/main.js"></script>


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/main.css">
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
							<a href="${pageContext.request.contextPath}/additems.jsp">新增人员</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath}/DeleteUser">退出登陆</a>
						</dd>
					</dl>
				</li>

			</ul>
	</div>

	</div>


	<div class="left_content">
		<div class="left_item"><span>&nbsp;通&nbsp;讯&nbsp;录</span></div>

		<div class="buttonDiv">
			<button class="button1" id="btn_build">新&nbsp;&nbsp;建</button>
	</div>

		<div class="table1_content" >
			<table id="table1" border="2">
				<thead>
					<tr>
						<th width="120px">姓&nbsp;&nbsp;名</th>
						<th width="140px">电&nbsp;&nbsp;话</th>
						<th width="200px">地&nbsp;&nbsp;址</th>
						<th width="130px">Q&nbsp;&nbsp;Q</th>
						<th width="260px">操&nbsp;&nbsp;作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="p" items="${requestScope.itemList }">

						<tr>

							<td align="center">${p.name }</td>

							<td align="center">${p.phone}</td>

							<td align="center">${p.address }</td>

							<td align="center">${p.qq }</td>

							<td align="center"><a
								href="${pageContext.request.contextPath}/UpdataItemsById?id=${p.id}">修改</a>&nbsp;&nbsp;
								<a
								href="${pageContext.request.contextPath}/deleteItemsById?id=${p.id}" onclick="javascript:return del()">刪除</a></td>

						</tr>

					</c:forEach>


				</tbody>
			</table>
	</div>

	</div>

	<%-- 管理员 ${username };<br>
密码  ${password };

	<table border="0" width="900px">

		<tr>

			<td align="center" style="font-size: 24px; color: #666">人员管理</td>

		</tr>

		<tr>

			<td align="right"><a
				href="${pageContext.request.contextPath}/person/addperson">添加</a></td>

		</tr>

	</table>

	<br />

	<table cellspacing="0" border="1" class="table1">

		<thead>

			<tr>

				<th width="300">姓名</th>

				<th width="300">身份证号</th>

				<th width="300">电话</th>

				<th width="300">地址</th>

				<th width="300">编辑</th>

				<th width="300">删除</th>

			</tr>

		</thead>

		<tbody>


		</tbody>

	</table>

	<br /> --%>

</body>
</html>
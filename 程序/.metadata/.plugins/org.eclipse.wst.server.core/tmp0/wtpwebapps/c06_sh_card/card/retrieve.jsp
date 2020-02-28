<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
  function deleteconfirm(id){
      if (confirm("确实要删除该记录吗？")){
          location.href="<%=basePath%>card2/delete?id=" + id;
		}
  } 
  function card(){location.href="<%=basePath%>card/find";}
  
  function selectall() {
		var a = f2.checkList.length;
		if (a != undefined){
			for (i = 0; i < a; i++)
				f2.checkList[i].checked = true;
		} else
			f2.checkList.checked = true;
  }

	function unselectall() {
		var a = f2.checkList.length;
		if (a != undefined){
			for (i = 0; i < a; i++)
				f2.checkList[i].checked = false;
		} else
			f2.checkList.checked = false;
	}

	function delchoose() {
		if (confirm("确实要删除所选吗？")) {
			document.f2.action="<%=basePath%>card2/delecteList";
		}
	}
	function revert(){
		if (confirm("确实要将选择的记录还原吗？")) {
			document.f2.action="<%=basePath%>card2/revert";
		}
	}	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回收站信息管理</title>
</head>
<body>
	<h3 align="center">回收站信息管理</h3>
	<form action="find" method="post">
		<div align="center">
			名片搜索: <input name="condition" type="text" />
			 <input type="submit" value="查询" />
		</div>
	</form>
	<br>
	<br>
	<s:form  method="post" name="f2">
		<table width="70%" border="0" cellpadding="3" cellspacing="1"
			align="center">
			<tr bgcolor="#8899cc">
				<td></td>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>单位</td>
				<td>手机</td>
				<td>电话</td>
				<td>Email</td>
				<td>通讯地址</td>
				<td>操作</td>
			</tr>
			<s:iterator var="card" value="listCard" status="list">
				<tr>
					<td><input type="checkbox" name="checkList" value="${card.id}"></td>
					<td><s:property value="#card.id" /></td>
					<td><s:property value="#card.name" /></td>
					<td><s:property value="#card.sex" /></td>
					<td><s:property value="#card.department" /></td>
					<td><s:property value="#card.mobile" /></td>
					<td><s:property value="#card.phone" /></td>
					<td><s:property value="#card.email" /></td>
					<td><s:property value="#card.address" /></td>
					<td><a href="javascript:deleteconfirm('${card.id}')">删除</a></td>
				</tr>

			</s:iterator>
		</table>
		
		<table align="center">
			<tr>
			    <td><input type="button" value="全选" onclick="selectall()" /></td>
				<td><input type="button" value="取消全选" onclick="unselectall()" /></td>
				<td><input type="submit" value="彻底删除所选" onclick="delchoose()" /></td>
				<td><input type="submit" value="还原所选" onclick="revert()" /></td>				
				<td><input type="button" value="进入名片管理" onclick="card()" /></td>
			</tr>
		</table>

	</s:form>
</body>
</html>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传记录页面</title>
</head>
<body>
	<h3>上传Excel文档</h3>
	<h4>注意：电子表只能为"*.xls",并且表中有左到右，各字段信息依次为：</h4>
	姓名,性别,单位,手机,电话,电子邮箱,地址
	<s:form action="/card/upload" method="post"
		enctype="multipart/form-data">
		<s:file name="file" label="提交文件"></s:file>
		<br>
		<br>
		<s:submit value="提交"></s:submit>
	</s:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="stu" class="com.phoenix.test.Student"></jsp:useBean>
    	<jsp:setProperty name="stu" property="*"/>
    	<h1>学生信息</h1>
    	学号：<jsp:getProperty name="stu" property="id"/><br/>
    	姓名：<jsp:getProperty name="stu" property="name"/><br/>

</body>
</html>
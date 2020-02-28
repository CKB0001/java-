<%@ page import="com.beans.*" contentType="text/html; charset=UTF-8" %>
<html><head> <title>Book Query</title>
</head>
<body>
请输入一个书号:<br>
<form action="BookQueryServlet" method = "post">
<input type="text" name="bookid"><br>
<input type="submit" value="提交">
</form>
</body>
</html>
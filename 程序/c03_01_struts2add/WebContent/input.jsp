<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>提交两实数的页面</title>
</head>
<body>
	<form action="opadd" method="post">
		<table>
			<tr>
				<th colspan="2">请输入两个实数：</th>
			</tr>
			<tr>
				<td align="right">加数：</td>
				<td><input type="text" name="add.x" /></td>
			</tr>
			<tr>
				<td align="right">被加数:</td>
				<td><input type="text" name="add.y" /></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="求和" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
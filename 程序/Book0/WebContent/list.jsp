<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户信息</title>
<body>
<table border=1 cellpadding="10" cellspacing="0">
     <thead>
          <tr>
             <th>编号</th>
             <th>用户名</th>
             <th>密码</th>
             <th>真实姓名</th>
             
          </tr>
      </thead>
    <tbody>
   
${st}
    <tr>
    	<td><input name="pclog" type="button" align="middle" value="返回" onClick="location.href='Login.jsp'"></td>
    </tr>
    </tbody>
   </table>
</body>
</html>
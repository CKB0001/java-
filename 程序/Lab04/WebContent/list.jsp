<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="edu.lzjtu.bean.Customer,java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%
	List<Customer> list = (List<Customer>)request.getAttribute("list"); 
%>
<body>
<table border=1 cellpadding="10" cellspacing="0">
     <thead>
          <tr>
             <th>编号</th>
             <th>姓名</th>
             <th>性别</th>
             <th>出生年月</th>
             <th>身份证号</th>
             <th>家庭住址</th>
             <th>联系电话</th>
          </tr>
      </thead>
    <tbody>
    <%
        for(Customer customer:list){
     %>
     <tr>
        <td><%=customer.getId()%></td>
        <td><%=customer.getCustName()%></td>
        <td><%=customer.getSex() %> </td>
        <td><%=customer.getBirthday() %></td>
        <td><%=customer.getIdcard() %></td>
        <td><%=customer.getAddress() %></td>
        <td><%=customer.getPhone() %></td>
     </tr>
    <%
        }
    %>
    <tr>
    	<td><input name="pclog" type="button" align="middle" value="返回" onClick="location.href='login.jsp'"></td>
    </tr>
    </tbody>
   </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>
<body>

<script language="javascript">
	function add(id)
	{
		window.confirm();
			window.alert(id);
		var name=id;
		var name1=name.value;
		window.alert(name1);
		<%System.out.println("successs");%>
		
		<%		System.out.println(%><%);%>
	}
</script>
	<form action=""name="form1">				
	    <%
	    	System.out.print("add(3)"); 
	    	int i=3;
	    %>			
		<input type="submit"name="i" value="添加到购物车"onclick="add('<%=i%>')">
		<%System.out.print("add(1)"); %>
	</form> 
</body>
</html>
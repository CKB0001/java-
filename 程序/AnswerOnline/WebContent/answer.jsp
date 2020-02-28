<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阅卷结果</title>
</head>
<body>
<%	
	int sum=0;

	String s1=request.getParameter("r1");
	if(s1!=null)
	{
		out.println("一、解答为：5+5="+s1+"  ");		
		if(s1.equals("10"))
		{
			out.println("正确！加1分"+"<br>");
			sum=sum+1;
		}
		else 
			out.println("错误！"+"<br>");	
	}
	else
		out.println("一、没有解答！");
	out.println("----------------------------------------------<br>");
	
	String s2[]=request.getParameterValues("r2");
	if(s2!=null)
	{
		out.println("二、解答为：奇数为： ");
		for( int i=0;i<s2.length;++i)
		{
			out.println(s2[i]+"  ");			
		}
		if(s2.length==2&&s2[0].equals("3")&& s2[1].equals("5"))
		{
			out.println("正确！加3分"+"<br>");
			sum=sum+3;
		}
		else
		{
			out.println("错误！"+"<br>");
		}		
	}
	else
	{
		out.println("二、没有解答！");	
	}
	out.println("----------------------------------------------<br>");
	
	String s3[]=request.getParameterValues("r3");
	if(s3!=null)
	{
		out.println("三、解答为：动态网页有： ");
		for(int i=0;i<s3.length;++i)
		{
			out.println(s3[i]+" ");
		}
		if(s3.length==3&&s3[0].equals("asp")&&s3[1].equals("php")&&s3[2].equals("jsp"))
		{
			out.println("正确！加2分"+"<br>");
			sum=sum+2;
		}
		else
		{
			out.println("错误！"+"<br>");
		}		
	}
	else
	{
		out.println("三、没有解答！");	
	}
	out.println("----------------------------------------------<br>");
	
	String s4=request.getParameter("r4");
	if(s4!=null)
	{
		out.println("四、解答为：服务器端的组件是有：");		
		out.println(s4+"  ");
		if(s4!=null&&s4.equals("servlet"))
		{
			out.println("正确！加2分"+"<br>");
			sum=sum+2;
		}
		else 
			out.println("错误！"+"<br>");	
	}
	else
		out.println("四、没有解答！");
	out.println("----------------------------------------------<br>");
	
	String s5=request.getParameter("text1");
	if(s5!=null)
	{
		out.println("五、解答为：");		
		out.println(s5+"  ");
		if(s5!=null&&s5.equals("request"))
		{
			out.println("正确！加1分"+"<br>");
			sum=sum+1;
		}
		else 
			out.println("错误！"+"<br>");	
	}
	else
		out.println("五、没有解答！");
	out.println("----------------------------------------------<br>");
	
	String s6=request.getParameter("r6");
	if(s6!=null)
	{
		out.println("六、解答为："+s6+"  ");		
		if(s6.equals("红色"))
		{
			out.println("正确！加1分"+"<br>");
			sum=sum+1;
		}
		else 
			out.println("错误！"+"<br>");	
	}
	else
		out.println("六、没有解答！");
	out.println("----------------------------------------------<br>");
	
	out.println("总分为"+sum);
%>
</body>
</html>
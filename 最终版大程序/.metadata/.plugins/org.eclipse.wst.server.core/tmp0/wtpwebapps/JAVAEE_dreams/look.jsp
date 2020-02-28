<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>观看内容</title>
	<style>
	.demo2-bg{
		    background: url(img/样式0.jpg) no-repeat;
		    background-size: cover;
		    width: 100%;
		    height: 100%;
		    position: relative;
		}
	.demo1-bg{
		    background: url(img/dan2.jpg) no-repeat;
		    background-size: cover;
		    width: 100%;
		    height: 100%;
		    position: relative;
		}
	.demo2{
		    position: absolute;
		    left: 0;
		    right: 0;
		    top: 0;
		    bottom: 0;
		    width: 100%;
		    height: 100%;
		    line-height: 30px;
		    
		    
		    background:rgba(255,255,255,0.3);
		}
		.sumbit{
		
		}
	.button2
			{
			background-color:#FFD700; 
		    border: none;
		    color: white;
		    padding:  8px 10px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    line-height:16px;
		     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
			}
	.button1
	{
			background-color:#ed1941; 
		    border: none;
		    color: white;
		    padding:  8px 10px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    line-height:16px;
		     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
			}
	</style>
</head>
<body class="demo2-bg" style="margin:auto;width:500px; height:100px;">
<div class="demo2">
<h2>查看梦的内容</h2>    
    	<input type="hidden" name="dream1.id" value="${ dream.id }">
    	<div>
   			${ biaoqian.b_name } 		
       	</div>
		 <div> 
		    睡觉时间：<input type="datetime-local" name="start" value="${start}" readonly="readonly">
		    起床时间：<input type="datetime-local" name="end" value="${ end }" readonly="readonly">
		    	</div>
    	<div>
    	标题：<input type="text" name="dream1.dreamname"  value="${ dream.dreamname } "readonly="readonly">
    	</div>
    	内容：
    	<div><textarea class="demo1-bg" rows="20" cols="60" name="dream1.text" readonly="readonly">  ${ dream.text } </textarea>   
    		 </div> 
    		 
    		 
    	<div class="sumbit" style="margin:auto;width:346px; height:50px;">
    	
    	<form action="findiddream"method="post" style="float:left;margin-left:10px;">
    		<div style="margin-left:10px;"><input type="hidden" name="id" value="${ dream.id }">
    		<button class="button2">编辑</button></div>
    	</form>
    	<div style="float:left;margin-left:10px;">
    	<form action="/JAVAEE_dreams/main.jsp">
    		<button class="button1">返回</button>
    	</form>
    	</div>
    	
    	</div>
</div>
</body>
</html>
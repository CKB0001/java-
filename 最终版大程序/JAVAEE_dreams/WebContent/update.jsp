<%@ page  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
  <title>修改梦</title>
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
  <body class="demo2-bg" style="margin:auto;width:500px; height:100px; font-size:15px;font-family:微软黑体">
  <div class="demo2">
    <h2>修改梦的内容</h2>    
    <form action="updateDream" method="post">
    	<input type="hidden" name="dream.id" value="${ dream.id }">
    		<div>
				<input type="radio" name="bid" value="2" checked="checked">开心&nbsp;
				<input type="radio" name="bid" value="3" >悲伤&nbsp;
				<input type="radio" name="bid" value="4" >恐惧&nbsp;
				<input type="radio" name="bid" value="5" >愤怒<br>
    		</div>
    	    	<div>
    	睡觉时间：<input type="datetime-local" name="start" value="${start}">
    	</div>
    	<div>
    	起床时间：<input type="datetime-local" name="end" value="${ end }">
    	</div>
    	<div>
    	标题：<input type="text" name="dream.dreamname" value="${ dream.dreamname }">
    	</div>

    	内容：
    	<div>
    	<textarea class="demo1-bg" rows="20" cols="60" name="dream.text" style='height:400px' onpropertychange="this.style.height = this.scrollHeight + 'px';"  oninput="this.style.height='auto';this.style.height = this.scrollHeight + 'px'">  ${ dream.text }</textarea></div>
    		 <div>
    	<input class="button1" type="submit" value="修改"> 	
    	<input class="button2" type="reset" value="取消">
    	</div>
    </form>
    <div style="float:right;">
    <form action="/JAVAEE_dreams/main.jsp">
   		 <input type="hidden" name="${user.u_name }" value="${user.u_name }">
   		 <input class="button2" type="submit" value="返回">
    </form>
    </div>
    </div>
  </body>
</html>

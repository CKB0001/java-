<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>请写出你最真实的梦</title>
<style>
.demo2-bg{
    background: url(img/dan2.jpg) no-repeat;
    background-size: cover;
    width: 500px;
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
.demo1-bg{
    background: url(img/样式0.jpg) no-repeat;
    background-size: cover;
    width: 100%;
    height: 100%;
    position: relative;
}
.button1{
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
.button2{
			background-color:#FF7F50; 
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
<body class="demo1-bg" style="margin:auto;width:500px; height:100px;">
<div class="demo2">
<h2 align="center">请写出你最真实的梦</h2>
    <form action="addDream" method="post">
    	<input type="hidden" name="dream.id" >
    	<div>
				<input type="radio" name="bid" value="2" checked="checked">开心&nbsp;
				<input type="radio" name="bid" value="3" >悲伤&nbsp;
				<input type="radio" name="bid" value="4" >恐惧&nbsp;
				<input type="radio" name="bid" value="5" >愤怒<br>
    	</div>
    	<div>
    	睡觉时间：
    	<input type="datetime-local" name="start" placeholder="睡觉时间：" value="${start}"></div>
    	<div>睡醒时间：
    	<input type="datetime-local" name="end" placeholder="睡醒时间：" value="${ end }">
    	</div>
    	<div><input type="text" placeholder="标题：" name="dream.dreamname" ></div>
    	内容：
    	<div ><textarea  class="demo2-bg" rows="20" cols="75" name="dream.text">  </textarea></div>
    	<div><input class="button1" type="submit" value="保存">
    	<input class="button2" type="reset" value="取消"></div>
    </form>
    </div>
</body>
</html>
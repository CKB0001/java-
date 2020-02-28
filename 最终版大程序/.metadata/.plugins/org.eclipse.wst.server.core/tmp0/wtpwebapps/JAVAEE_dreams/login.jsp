<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh">	
  <head>	
  <meta charset="UTF-8" />		
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />		
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />		
  <title>登录页</title>	
  	<style>		
      body {
        margin: 0;				
        padding: 0;				
        font-family: sans-serif;			
        	background: #34495e;			
          }			
          .box {			
           width: 300px;			
          padding: 40px;			
          position: absolute;				
          top: 50%;				
          left: 50%;				
          transform: translate(-50%, -50%);			
           background: #191919;				
          text-align: center;			}		
        	.box h1 {		
          color: white;				
          text-transform: uppercase;				
          font-weight: 500;			
          }		
          .box input[type='text'],.box input[type='password'] {				
            border: 0;				
            background: none;				
            display: block;			
            margin: 20px auto;				
            text-align: center;				
            border: 2px solid #3498db;			
            padding: 14px 10px;				
            width: 200px;				
            outline: none;				
            color: white;				
            border-radius: 24px;				
            transition: 0.25s;			}			
            .box input[type='text']:focus,.box input[type='password']:focus {				
              width: 280px;				
              border-color: #2ecc71;		
              	}			
            .submit {				
              border: 0;				
              background: none;				
              margin: 20px auto;				
              margin-top: 0;				
              display: inline-block;				
              text-align: center;			
            	border: 2px solid #3498db;			
            	padding: 10px 30px;				
              outline: none;				
              color: white;				
              border-radius: 24px;				
              transition: 0.25s;				
              cursor: pointer;				
              text-decoration: none;				
              font-size: 12px;			}		
            .submit:hover {				
              background: #2ecc71;				
              border-color: #2ecc71;			}		
            h1 {
              color: ghostwhite;
              text-align: center;	
            }
              </style>	
  </head>	
  <body>	
  <form action="login" method="post">	
    <h1>清梦</h1>
    <div class="box">			
      <h1>登录</h1>			
      <input type="text" placeholder="userName" name="user.u_name" />			
      <input type="password" placeholder="userPassword" name="user.u_password"/>	
      <input type="submit" class="submit" value="login">
      <a class="submit" href="User/register.jsp" >Sign Up</a>
      
      <!--  
      
      <a class="submit" >Login</a>	
      <a class="submit" >Sign Up</a>	-->
    </div>
    </form>	
  </body>
</html>

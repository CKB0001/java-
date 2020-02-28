package com.shiyan11.shiyan;

import org.aspectj.lang.JoinPoint;

public class X {
	public void mx1(JoinPoint joinpoint)
	{
		MyLog my=new MyLog();
		my.before();
	}
	public void  mx2(JoinPoint joinpoint)
	{
		MyLog my = new MyLog();
		my.after();
	}
}

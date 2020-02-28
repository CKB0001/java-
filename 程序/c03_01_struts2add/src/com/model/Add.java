package com.model;

public class Add {
	double x; //第1个加数
	double y; //第2个加数
	double sum; //和值
	
	//构造方法
	public Add() {
		this.x = 0;
		this.y = 0;	
	}
	//带参数的构造方法
	public Add(double x, double y) {		
		this.x = x;
		this.y = y;		
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSum() {
		return x+y;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}	

}

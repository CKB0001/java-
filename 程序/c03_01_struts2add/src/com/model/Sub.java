package com.model;

public class Sub {

	
		double x; //绗�1涓姞鏁�
		double y; //绗�2涓姞鏁�
		double sub; //鍜屽��
		
		//鏋勯�犳柟娉�
		public Sub() {
			this.x = 0;
			this.y = 0;	
		}
		//甯﹀弬鏁扮殑鏋勯�犳柟娉�
		public Sub(double x, double y) {		
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
		public double getSub() {
			return x-y;
		}
		public void setSub(double sub) {
			this.sub = sub;
		}	

	

}

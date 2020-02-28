package com.action;

import com.model.Add;

public class AddAction {
	private Add add; // 业务模型对象属性

	// 不带参数的默认构造方法
	public AddAction() {
	}

	public Add getAdd() {
		return add;
	}

	public void setAdd(Add add) {
		this.add = add;
	}

	// 求值Action方法,并返回"-"或“+”
	public String executeAdd() throws Exception {
		String forward = null;
		if (add.getSum() < 0) {
			forward = "-";
		} else {
			forward = "+";
		}
		return forward;
	}

}

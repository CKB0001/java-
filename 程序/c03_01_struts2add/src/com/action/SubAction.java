package com.action;

import com.model.Add;
import com.model.Sub;

public class SubAction {
	private Sub sub; // 涓氬姟妯″瀷瀵硅薄灞炴��

	// 涓嶅甫鍙傛暟鐨勯粯璁ゆ瀯閫犳柟娉�
	public SubAction() {
	}

	public Sub getSub() {
		return sub;
	}

	public void setSub(Sub sub) {
		this.sub = sub;
	}

	// 姹傚�糀ction鏂规硶,骞惰繑鍥�"-"鎴栤��+鈥�s
	public String executeSub() throws Exception {
		String forward = null;
		if (sub.getSub() < 0) {
			forward = "-";
		} else {
			forward = "+";
		}
		return forward;
	}
}

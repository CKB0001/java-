package com.programmer.interceptor;

 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		/*Object loginUserName = ActionContext.getContext().getSession().get("u_name");  
        if(null == loginUserName){  
            return Constants.VIEW_LOGIN;  // 这里返回用户登录页面视图  
        }  
        return invoker.invoke();  */
		return "sss";
	}

}

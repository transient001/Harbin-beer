package com.sxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{
	//执行请求方法后执行
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	//执行了请求方法，但还没跳转jsp页面时候执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//请求资源之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {	
		//看用户是否登陆，登陆放行，没登录返回登陆页面
		User user=(User)request.getSession().getAttribute("userLogin");
		if(user!=null){
			return true;
		}else{
			//跳转到登陆页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
	
	}

}

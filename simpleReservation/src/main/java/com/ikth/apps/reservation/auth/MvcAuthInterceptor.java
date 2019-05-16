package com.ikth.apps.reservation.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MvcAuthInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public void postHandle(HttpServletRequest request
				, HttpServletResponse response
				, Object handler
				, ModelAndView modelAndView) throws Exception 
	{
		if(modelAndView == null) {	
			return;
		}
		
		SecurityContext secureCtxt= SecurityContextHolder.getContext();
		
		if(secureCtxt == null) {
			return;
		}
		
		Authentication auth= secureCtxt.getAuthentication();
		if(auth == null) {
			return;
		}
		
		Object principal= auth.getPrincipal();
		
		if(principal instanceof String) {
			modelAndView.addObject("loginReqUrl", "loginView");
			modelAndView.addObject("logInOut", "로그인");
		} else if(principal instanceof UserDetails){
			final String name= ((UserDetails) principal).getUsername();
			modelAndView.addObject("loginReqUrl", "userLogout");
			modelAndView.addObject("logInOut", "로그아웃");
			modelAndView.addObject("userName", name);
		}
	}
}

package com.nt.interceptors;

import java.time.LocalTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckingInterceptor implements HandlerInterceptor {

	public TimeCheckingInterceptor() {
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		int time = 0;
		RequestDispatcher rd = null;

		time = LocalTime.now().getHour();
		
		if(time < 9 || time > 18) {
			System.out.println("TimeCheckingInterceptor.preHandle()");
			rd = request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}else {
			return true;
		}			
	}
}

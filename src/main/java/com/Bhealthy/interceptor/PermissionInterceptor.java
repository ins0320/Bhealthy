package com.Bhealthy.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // spring bean으로 등록
public class PermissionInterceptor implements HandlerInterceptor  {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		// 요청 URL Path를 꺼낸다.
		String uri = request.getRequestURI();
		// 로그인 여부
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// 비로그인 && /post 페이지 접근 금지
		if (userId == null && uri.startsWith("/post")) {
			response.sendRedirect("/post/main-view");
			return false; // 원래 요청된 컨트롤러 수행 X
		}
		return true; // 컨트롤러 수행
	}
	

}


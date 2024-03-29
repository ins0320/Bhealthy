package com.Bhealthy.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	//@TimeTrace2
	// 로그인
	@GetMapping("/sign-in-view")
	public String signInView(Model model){
		model.addAttribute("viewName", "user/signIn");
		return "template/layout";
	}
	
	// 회원가입
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/signUp");
		return "template/layout";
	}
	
	// 로그아웃
	@RequestMapping("/sign-out")
	public String signOut(HttpSession session) {
		// 세션에 있는 내용을 모두 비운다.
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		// redirect 로그인 화면으로 이동
		return "redirect:/user/sign-in-view "; 		
	}
}

package com.Bhealthy.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/sign-up-view")
	public String signInView(Model model){
		model.addAttribute("viewName", "user/signUp");
		return "template/layout";
	}
}
package com.Bhealthy.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {
	@GetMapping("/main-view")
	public String postMainView(Model model) {
		model.addAttribute("viewName", "post/main");
		return "template/layout";
	}

}

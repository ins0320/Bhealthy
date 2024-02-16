package com.Bhealthy.post;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Bhealthy.post.bo.PostBO;
import com.Bhealthy.post.entity.PostEntity;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/main-view")
	public String postMainView(Model model) {
		model.addAttribute("viewName", "post/main");
		return "template/layout";
	}

	@GetMapping("/list-view")
	public String postListView(
			Model model
			, HttpSession session ) {
		
		// 로그인 여부 조회
		Integer userId = (Integer)session.getAttribute("userId");
		if (userId == null) {
			// 비로그인이면 로그인 페이지로 이동
			return "redirect:/user/sign-in-view";
		}
		
		List<PostEntity> postList = postBO.getPostEntityList();
		
		
		
		model.addAttribute("postList", postList);
		model.addAttribute("viewName", "post/list");
		return "template/layout";
	}
	
	@GetMapping("/create-view")
	public String postCreateView(Model model) {
		model.addAttribute("viewName", "post/create");
		return "template/layout";
	}
	
	// 글 하나당 댓글, 공감하기 뿌리기
	@GetMapping("/detail-view")
	public String postDetailView(Model model, HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		model.addAttribute("viewName", "post/detail");
		return "template/layout";
	}
	
	
}

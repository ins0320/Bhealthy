package com.Bhealthy.comment;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentRestController {

	@Autowired
	private CommentBO commentBO;
	
	// 댓글 작성
	/**
	 * @API: 댓글 작성 API
	 * @param postId
	 * @param content
	 * @param session
	 * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> commentCrate(
			@RequestParam("postId") int postId,
			@RequestParam("content") String content
			,HttpSession session){
		
		Integer userId =(Integer)session.getAttribute("userId");
		
		commentBO.addComment(postId, userId, content);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> commentDelete(@RequestParam("commentId") int commentId, HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		
		// 로그인 여부 확인
		Integer userId = (Integer)session.getAttribute("userId");
		
		if (userId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인이 되지 않은 사용자 입니다.");
			return result;
		} else {
			commentBO.deleteComment(commentId);
		}
		
		// 응답값
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
}

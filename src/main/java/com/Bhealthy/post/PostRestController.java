package com.Bhealthy.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Bhealthy.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
public class PostRestController {

	@Autowired
	PostBO postBO;
	
	
	
	/**
	  * @API: 글 작성  API
	  * @param content
	  * @param file
	  * @param session
	  * @return
	 */
	@PostMapping("/create")
	public Map<String, Object> postCreate(	
			@RequestParam("content") String content,
			@RequestParam(value = "file", required = false) MultipartFile file
			, HttpSession session ){
		
		// 글쓴이 번호 - session에 저장 후 꺼내쓴다.
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		// db 저장
		postBO.addPost(userId, userLoginId, content, file);
		
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;
		
	}
	
	
	/**
	 * @API: 글 삭제  API
	 * @param id
	 * @param session
	 * @return
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> PostDelete(@RequestParam("id") int id,
			HttpSession session){
		Integer userId = (Integer) session.getAttribute("userId");
		postBO.deletePostByIdAndUserId(id, userId);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인을 다시 해주세요.");
			return result;
		} else {
			result.put("code", 200);
			result.put("result", "성공");
		}
		return result;
	}
	
	
	
}

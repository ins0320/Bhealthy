package com.Bhealthy.sympathy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.sympathy.bo.SympathyBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class SympathyRestController {

	@Autowired
	private SympathyBO sympathyBO;
	
	// GET: /like?postId=13  @RequestParam("postId")
	// GET: /like/13   @PathVariable
	
	/**
	 * @API: 공감하기 토글(추가/삭제) API
	 * @param postId
	 * @param session
	 * @return
	 */
	@RequestMapping("/sympathy/{postId}")
	public Map<String, Object> sympathyToggle(
			@PathVariable(name = "postId") int postId,
			HttpSession session){
		
		Map<String, Object> result = new HashMap<>();
		
		// 로그인 여부 확인
		Integer userId = (Integer) session.getAttribute("userId");
		
		// 혹시 모르니 검증
		if (userId == null) {
			result.put("code", 300);
			result.put("error_message", "로그인을 해주세요.");
			return result;
		} else {
			
			// BO 호출
			sympathyBO.SympathyToggle(postId, userId);
			
			// 응답값
			result.put("code", 200);
			result.put("result", "success");
		}
		return result;
		
	}
}

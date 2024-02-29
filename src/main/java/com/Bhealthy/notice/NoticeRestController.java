package com.Bhealthy.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.notice.bo.NoticeBO;

@RestController
public class NoticeRestController {

	
	@Autowired
	private NoticeBO noticeBO;
	
	/**
	 * @API: 관리자 공지사항 작성하기
	 * @param title
	 * @param content
	 * @return
	 */
	@PostMapping("/admin/notice/create")
	public Map<String, Object> noticeCreate(@RequestParam("title") String title, @RequestParam("content") String content){
		
		noticeBO.addNotice(title, content);
			
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		result.put("code", 200);
		result.put("result", "success");
	
		return result;
	}
	
	/** 관리자 공지사항 삭제하기
	 * @API: 
	 * @param postId
	 * @return
	 */
	@DeleteMapping("/admin/notice/delete")
	public Map<String, Object> noticeDelete(@RequestParam("postId") int postId){
		
		noticeBO.deleteNotice(postId);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		result.put("code", 200);
		result.put("result", "success");
	
		return result;
	}
	
	/** 관리자 공지사항 수정하기
	 * @API: 
	 * @param postId
	 * @param title
	 * @param content
	 * @return
	 */
	@PostMapping("/admin/notice/update")
	public Map<String, Object> noticeUpdate(
			@RequestParam("postId") int postId,
			@RequestParam("title") String title,
			@RequestParam("content") String content){
		
		noticeBO.updateNotice(postId, title, content);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
				
		result.put("code", 200);
		result.put("result", "success");
			
		return result;
	}
	
}

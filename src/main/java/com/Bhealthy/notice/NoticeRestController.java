package com.Bhealthy.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.notice.bo.NoticeBO;

@RestController
public class NoticeRestController {

	
	@Autowired
	private NoticeBO noticeBO;
	
	@PostMapping("/admin/notice/create")
	public Map<String, Object> noticeCreate(@RequestParam("title") String title, @RequestParam("content") String content){
		
		noticeBO.addNotice(title, content);
			
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		result.put("code", 200);
		result.put("result", "success");
	
		return result;
	}
	
	
}

package com.Bhealthy.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bhealthy.notice.bo.NoticeBO;
import com.Bhealthy.notice.entity.NoticeEntity;

@Controller
public class NoticeController {

	@Autowired
	private NoticeBO noticeBO;
	
	
	// 관리자 페이지
	@GetMapping("/admin/notice/create-view")
	public String adminNoticeCreate(Model model) {
		model.addAttribute("viewName", "notice/adminCreate");
		return "template/layout";
	}
	
	@GetMapping("/admin/notice/list-view")
	public String adminNoticeList( Model model) {
		
		List<NoticeEntity> noticeList = noticeBO.getNoticeEntity();
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("viewName", "notice/adminList");
		return "template/layout";
	}
	
	@GetMapping("/admin/notice/detail-view")
	public String AdminNoticeDetailView(@RequestParam("id") int id, Model model) {
		
		List<NoticeEntity> noticeList = noticeBO.getNoticeEntityById(id);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("viewName", "notice/adminDetail");
		return "template/layout";
	};
	
	
	// 일반 사용자 페이지	
	@GetMapping("/notice/list-view")
	public String noticeList( Model model) {
		
		List<NoticeEntity> noticeList = noticeBO.getNoticeEntity();
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("viewName", "notice/list");
		return "template/layout";
	}
	
	@GetMapping("/notice/detail-view")
	public String noticeDetailView(@RequestParam("id") int id, Model model) {
		
		List<NoticeEntity> noticeList = noticeBO.getNoticeEntityById(id);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("viewName", "notice/detail");
		return "template/layout";
	};
	

}

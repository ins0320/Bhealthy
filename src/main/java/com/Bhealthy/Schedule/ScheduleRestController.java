package com.Bhealthy.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.schedule.scheduleBO.ScheduleBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class ScheduleRestController {

	@Autowired
	private ScheduleBO scheduleBO;
	
	@PostMapping("/admin/schedule/create")
	public Map<String, Object> bookingCreate(
			@RequestParam("title") String title,
			@RequestParam("start") Date start,
			@RequestParam("end") Date end,
			HttpSession session ){
		
		// 글쓴이 번호 - session에 저장 후 꺼내쓴다.
		int userId = (int)session.getAttribute("userId");
		
		if( userId == 6 && title != "") {		
			scheduleBO.addSchedule(title, start, end);
		}
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		
		if( userId != 6) {
			result.put("code",403);
			result.put("result", "Forbidden");
			return result;
		} 
		
		result.put("code", 200);
		result.put("result", "succcess");
		
		return result;
	}

	@DeleteMapping("/schedule/deleteAll")
	public Map<String, Object> deleteAllSchedule( HttpSession session ) {
		
		// 글쓴이 번호 - session에 저장 후 꺼내쓴다.
		int userId = (int)session.getAttribute("userId");
		
		if( userId == 6) {	
			scheduleBO.deleteAllSchedule();	
		}
		Map<String, Object> result = new HashMap<>();
		
		if( userId != 6) {
			result.put("code",403);
			result.put("result", "Forbidden");
			return result;
		} 
		
		result.put("code",200);
		result.put("result", "success");
		
		return result;
		
	}
	
	@Transactional
	@DeleteMapping("/schedule/detele")
	public Map<String, Object> deleteSchedule( HttpSession session, @RequestParam("title") String title) {
		
		// 글쓴이 번호 - session에 저장 후 꺼내쓴다.
		int userId = (int)session.getAttribute("userId");
		
		if( userId == 6) {	
			scheduleBO.deleteSchedule(title);
		}
		Map<String, Object> result = new HashMap<>();
		
		if( userId != 6) {
			result.put("code",403);
			result.put("result", "Forbidden");
			return result;
		} 
		
		result.put("code",200);
		result.put("result", "success");
		
		return result;
		
	}
	
	@GetMapping("/schedule/list")
	public List<Map<String,  Object>>  getScheduleList(){		
		return scheduleBO.getScheduleDetailList();
	};
}

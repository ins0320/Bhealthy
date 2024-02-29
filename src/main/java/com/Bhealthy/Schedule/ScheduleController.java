package com.Bhealthy.schedule;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bhealthy.schedule.bo.ScheduleBO;
import com.Bhealthy.schedule.entity.ScheduleEntity;

@Controller
public class ScheduleController {

	@Autowired
	private  ScheduleBO schedule;
	
	
		@GetMapping("/schedule/check-view")
		public String bookingCreate(Model model){		
			model.addAttribute("viewName", "schedule/create");
			return "template/layout";
		};	
}

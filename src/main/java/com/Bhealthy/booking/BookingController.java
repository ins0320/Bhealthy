package com.Bhealthy.booking;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bhealthy.booking.bo.BookingBO;
import com.Bhealthy.booking.entity.BookingEntity;

@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	
		@GetMapping("/booking/create-view")
		public String bookingCreate(Model model){		
			model.addAttribute("viewName", "booking/create");
			return "template/layout";
		};	
}

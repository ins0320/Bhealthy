package com.Bhealthy.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {

		@GetMapping("/booking/create-view")
		public String monthlyInput(Model model){		
			model.addAttribute("viewName", "booking/create");
			return "template/layout";
		};
}

package com.Bhealthy.booking;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.booking.bo.BookingBO;

import jakarta.servlet.http.HttpSession;

@RestController
public class BookingRestController {

	@Autowired
	private BookingBO bookingBO;
	
	@PostMapping("/admin/booking/create")
	public Map<String, Object> bookingCreate(
			@RequestParam("title") String title,
			@RequestParam("start") Date start,
			@RequestParam("end") Date end,
			HttpSession session ){
		
		// 글쓴이 번호 - session에 저장 후 꺼내쓴다.
		int userId = (int)session.getAttribute("userId");
		
		if( userId == 6) {		
			bookingBO.addBooking(title, start, end);
		}
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if( userId != 6) {
			result.put("code",403);
			result.put("result", "Forbidden");
		} 
		
		result.put("code", 200);
		result.put("result", "succcess");
		
		return result;
	}

	@GetMapping("/booking/list")
	public List<Map<String,  Object>>  getBookingList(){		
		return bookingBO.getBookingDetailList();
	};
}

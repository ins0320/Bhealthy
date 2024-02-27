package com.Bhealthy.booking;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.booking.bo.BookingBO;

@RestController
public class BookingRestController {

	@Autowired
	private BookingBO bookingBO;
	
	@PostMapping("/admin/booking/create")
	public Map<String, Object> bookingCreate(
			@RequestParam("title") String title,
			@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
			@RequestParam("start") LocalDateTime start,
			@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
			@RequestParam("end") LocalDateTime end){
		
		bookingBO.addBooking(title, start, end);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code",200);
		result.put("result", "success");
		
		return result;
	}
}

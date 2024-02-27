package com.Bhealthy.booking.bo;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.booking.entity.BookingEntity;
import com.Bhealthy.booking.repository.BookingRepository;

@Service
public class BookingBO {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	// input: title, start, end   output: int(id)
	public int addBooking(String title, LocalDateTime start, LocalDateTime end) {
		BookingEntity bookingEntity = bookingRepository.save(
					BookingEntity.builder()
					.title(title)
					.start(start)
					.end(end)
					.build()
				);
		return bookingEntity == null ? null: bookingEntity.getId();
	}
	
}

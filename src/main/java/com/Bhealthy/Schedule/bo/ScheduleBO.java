package com.Bhealthy.schedule.bo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.schedule.entity.ScheduleEntity;
import com.Bhealthy.schedule.repository.ScheduleRepository;

@Service
public class ScheduleBO {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	// input: title, start, end   output: int(id)
	public int addBooking(String title, Date start, Date end) {
		ScheduleEntity bookingEntity = scheduleRepository.save(
					ScheduleEntity.builder()
					.title(title)
					.start(start)
					.end(end)
					.build()
				);
		return bookingEntity == null ? null: bookingEntity.getId();
	}
	
	// input: id  output: List<BookingEntity>
	public List<Map<String,  Object>> getBookingDetailList(){
		
		// 최종 List (조회한 List(title,start,end) 한 세트)
		List<Map<String,  Object>> bookingDetailList = new ArrayList<>();
		
		// 조회한 List
		List<ScheduleEntity> bookingList = scheduleRepository.findAll();
		
		//조회한 bookingList를 하나씩 꺼내서 booking로 저장 ->  map 형태로 하나씩 저장
		for(ScheduleEntity booking : bookingList) {
			String title = booking.getTitle();
			Date start = booking.getStart();
			Date end = booking.getEnd();
			
			Map<String, Object> map = new HashMap<>();
			map.put("title", title);
			map.put("start", start);
			map.put("end", end);
			
			bookingDetailList.add(map);
		}
		return bookingDetailList;
	}
}

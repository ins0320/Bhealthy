package com.Bhealthy.Schedule.scheduleBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.Schedule.entity.ScheduleEntity;
import com.Bhealthy.Schedule.repository.ScheduleRepository;

@Service
public class ScheduleBO {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	// input: title, start, end   output: int(id)
	public int addSchedule(String title, Date start, Date end) {
		ScheduleEntity scheduleEntity = scheduleRepository.save(
					ScheduleEntity.builder()
					.title(title)
					.start(start)
					.end(end)
					.build()
				);
		return scheduleEntity == null ? null: scheduleEntity.getId();
	}
	
	// input: x output: x
	public void deleteAllSchedule() {
		scheduleRepository.deleteAll();
	}
	public void deleteSchedule(String title) {
		scheduleRepository.deleteAllByTitle(title);
	}
	
	// input: x  output: List<BookingEntity>
	public List<Map<String,  Object>> getScheduleDetailList(){
		
		// 최종 List (조회한 List(title,start,end) 한 세트)
		List<Map<String,  Object>> scheduleDetailList = new ArrayList<>();
		
		// 조회한 List
		List<ScheduleEntity> scheduleList = scheduleRepository.findAll();
		
		//조회한 bookingList를 하나씩 꺼내서 booking로 저장 ->  map 형태로 하나씩 저장
		for(ScheduleEntity schedule : scheduleList) {
			String title = schedule.getTitle();
			Date start = schedule.getStart();
			Date end = schedule.getEnd();
			
			Map<String, Object> map = new HashMap<>();
			map.put("title", title);
			map.put("start", start);
			map.put("end", end);
			
			scheduleDetailList.add(map);
		}
		return scheduleDetailList;
	}
}

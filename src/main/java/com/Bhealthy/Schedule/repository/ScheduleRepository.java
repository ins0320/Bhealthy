package com.Bhealthy.Schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhealthy.Schedule.entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer>{

	public List<ScheduleEntity> findAllById(int id);

	public void deleteAllByTitle(String title);
	
 
}

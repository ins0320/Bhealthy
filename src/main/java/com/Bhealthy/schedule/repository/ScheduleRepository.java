package com.Bhealthy.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhealthy.schedule.entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer>{

	public List<ScheduleEntity> findAllById(int id);

	public void deleteAllById(int id);
	
 
}


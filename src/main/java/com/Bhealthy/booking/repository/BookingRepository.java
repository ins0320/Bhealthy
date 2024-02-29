package com.Bhealthy.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhealthy.booking.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{

	public List<BookingEntity> findAllById(int id);
	
 
}

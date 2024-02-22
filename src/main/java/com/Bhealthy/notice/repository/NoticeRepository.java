package com.Bhealthy.notice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Bhealthy.notice.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {

	// notice 리스트 조회하기
	public List<NoticeEntity> findAll();
	
	// id 일치하는 notice 조회하기
	public List<NoticeEntity> findAllById(int id);
}

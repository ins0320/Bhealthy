package com.Bhealthy.sympathy.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.Bhealthy.sympathy.domain.Sympathy;
import com.Bhealthy.sympathy.mapper.SympathyMapper;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Transactional
@Slf4j
class SympathyTest {

	@Autowired
	private SympathyBO sympathyBO;
	
	@Autowired
	private SympathyMapper sympathyMapper;
	
	//@Test
	@DisplayName("공감하기 삭제 테스트")
	void 공감하기() {
		log.info("#####공감하기 삭제 테스트");
		//given
		Sympathy sympathy = new Sympathy();
		
		sympathy.setPostId(1);
		sympathy.setUserId(2);
		
		// when
		int sympathyCount = sympathyMapper.selectSympathyCountByPostOrIdUserId(sympathy.getPostId(), sympathy.getUserId());
		
		// then
		// 공감 존재 -> 삭제
		assertTrue(sympathyCount > 0);
		sympathyMapper.deleteSympathyByPostIdOrUserId(sympathy.getPostId(), sympathy.getUserId());
		log.info("#####공감하기 삭제 완료:" + sympathyCount);						
		}
	
	@Test
	@DisplayName("공감하기 추가 테스트")
	void 공감하기삭제() {
		log.info("#####공감하기 추가 테스트");
		//given X
		Sympathy sympathy = new Sympathy();
				
		sympathy.setPostId(5);
		sympathy.setUserId(5);
		// when
		int sympathyCount = sympathyMapper.selectSympathyCountByPostOrIdUserId(sympathy.getPostId(), sympathy.getUserId());
		
		// then
		log.info("공감하기" + sympathyCount);
		 		
		assertNotEquals(sympathyCount, 1);// 공감 없음 -> 추가
		sympathyMapper.insertSympathy(sympathy.getPostId(), sympathy.getUserId());
		sympathyCount = sympathyMapper.selectSympathyCountByPostOrIdUserId(sympathy.getPostId(), sympathy.getUserId());
		log.info("#####공감하기 추가 완료:" + sympathyCount);
		
	}
		 
}

package com.Bhealthy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j

// @SpringBootTest  // spring 기능을 쓸 때
class BhealthyApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	// 수식 테스트 ( 간단한 단위 테스트)
	@Test
	void 더하기테스트() {
		log.info("$$$$$$ 더하기 테스트 시작");
		int a = 10;
		int b = 20;
		
		
		assertEquals(30, a + b);  // 30과 a + b가 일치하면 왼쪽 JUNIT에 초록색으로 표시
	}

}

package com.Bhealthy.user.bo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.Bhealthy.common.EncryptUtils;
import com.Bhealthy.user.domain.User;
import com.Bhealthy.user.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional // db rollback
class UserBOTest {

	@Autowired
	UserBO userBO;
	
	@Autowired
	UserMapper userMapper;
	
	
	// @Test
	@DisplayName("암호화 적용한 로그인 테스트")
	void 로그인2() {
		log.info("$$$$$$ 암호화 적용한 로그인 테스트");
		
		// given
		User user = new User();
		user.setLoginId("bbbb");
		user.setPassword("bbbb");
		String hashedPassword = EncryptUtils.sha256(user.getPassword());
		
		// when
		User loginUser = userBO.getUserByLoginIdAndPassword(user.getLoginId(), hashedPassword);
		
		// then
		log.info("$$$$$$ 암호화 적용한 로그인 테스트 성공");

	}
	
	//@Test
	@DisplayName("회원가입 테스트")
	void 회원가입() {
		log.info("$$$$ 회원가입 테스트");
		
		// given
		User user = new User();
		user.setLoginId("aaaa");
		user.setPassword("aaaa");
		user.setName("aaaa");
		user.setEmail("aaaa@naver.com");
		
		String hashedPassword = EncryptUtils.sha256(user.getPassword());
		
		// when
		userBO.addUser(user.getLoginId(), hashedPassword,user.getName() , user.getEmail());
		
		// then
		log.info("$$$$$$ 회원가입 테스트 성공");
	}
	
	//@Test
	@DisplayName("아이디 중복확인 테스트")
	void 아이디중복확인() {
		log.info("$$$$$$ 아이디 중복확인 테스트");
				
		// given
		User user = new User();
		user.setLoginId("aaaa");
			
		// when
		User user1 = userBO.getUserByLonginId(user.getLoginId()); // 중복
		User user2 = userBO.getUserByLonginId("bbbb"); // 가입가능
						
		// then	
		assertEquals(user.getLoginId(), user1.getLoginId()); //중복
		assertNotEquals(user.getLoginId(), user2.getLoginId()); // 가입가능
	
		}
	


}

package com.Bhealthy.user.bo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.Bhealthy.common.EncryptUtils;
import com.Bhealthy.user.domain.User;
import com.Bhealthy.user.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@Transactional // db rollback
class UserBOTest {
	
	@Autowired 
	MockMvc mockMvc;
	
	@Autowired
	UserBO userBO;
	
	@Autowired
	UserMapper userMapper;
	
//	@BeforeEach
//    void beforeEach() {
//		User user = new User();
//		user.setLoginId("aaaa");
//		user.setPassword("aaaa");
//		user.setEmail("aaaa");
//		user.setName("aaaa");
//		userBO.addUser(user.getLoginId(), user.getPassword(), user.getEmail(), user.getName());
//    }
//	
	
	//@Test
	void 로그인() {
		log.info("$$$$$$ 로그인 테스트");
		
		// given
		User user = new User();
		user.setLoginId("aaaa");
		user.setPassword("aaaa");
		
		// when
		//User loginUser = userBO.getUserByLoginIdAndPassword(user);
		User loginUser = userBO.getUserByLoginIdAndPassword(user.getLoginId(), user.getPassword());
		
		
		// then		
		assertEquals(user.getLoginId(),loginUser.getLoginId());
		assertEquals(user.getPassword(),loginUser.getPassword());

	}
	
	@Test
	void 로그인2() {
		log.info("$$$$$$ 암호화 적용한 로그인 테스트");
		
		// given
		User user = new User();
		user.setLoginId("bbbb");
		user.setPassword("bbbb");
		String hashedPassword = EncryptUtils.sha256(user.getPassword());
		
		// when
		//User loginUser = userBO.getUserByLoginIdAndPassword(user.getLoginId(), user.getPassword());
		User loginUser = userBO.getUserByLoginIdAndPassword(user.getLoginId(), hashedPassword);
		

	}
	
//	
//	@Test
//	void 회원가입() {
//		log.info("@@@@@ 회원가입 테스트");
//		
//		// given
//		User user = new User();
//		user.setLoginId("aaaa");
//		user.setPassword("aaaa");
//		user.setEmail("aaaa@naver.com");
//		user.setName("aaaa");
//		
//		// when
//		//User joinUser =  userBO.addUser(user.getLoginId(), user.getPassword(), user.getEmail(), user.getName());
//	}


}

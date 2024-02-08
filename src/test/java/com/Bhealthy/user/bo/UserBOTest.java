package com.Bhealthy.user.bo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Test
	void 회원가입_로그인() {
		log.info("$$$$$$ 회원가입 로그인 테스트");
		// given
		User user = new User();
		user.setLoginId("test");
		user.setPassword("test");
		user.setEmail("test@test.com");
		user.setName("test");
		
		// when
		User saveUser = userBO.addUser(user);
	
		
		// then
		User loginUser = userBO.getUserByLoginIdAndPassword(saveUser.getLoginId(), saveUser.getPassword());
		Assertions.assertThat(user.getLoginId()).isEqualTo(loginUser.getLoginId());
		Assertions.assertThat(user.getPassword()).isEqualTo(loginUser.getPassword());

	}
	


}

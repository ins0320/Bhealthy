package com.Bhealthy.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.user.domain.User;
import com.Bhealthy.user.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	private Object loginId;
	private String password;
	

	
	// 아이디 중복 확인
	// input: loginId output: User
	public User getUserByLonginId(String loginId) {
		return userMapper.selectUserByLonginId(loginId);
	}
		
	// 로그인
	// input: loginId, password   output: User
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userMapper.selectUserByLoginIdAndPassword(loginId, password);
	}
	
	
	// 회원가입
	// input: params output: X
	public void addUser(String loginId, String password, String name, String email) {
		 userMapper.insertUser(loginId, password, name, email);
	}


	public User addUser(User user) {
		return user;
		// TODO Auto-generated method stub
		
	}

}

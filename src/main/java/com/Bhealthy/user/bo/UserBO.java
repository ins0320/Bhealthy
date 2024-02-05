package com.Bhealthy.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.user.domain.User;
import com.Bhealthy.user.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	// input: loginId output: User
	public User getUserByLonginId(String loginId) {
		return userMapper.selectUserByLonginId(loginId);
	}
}

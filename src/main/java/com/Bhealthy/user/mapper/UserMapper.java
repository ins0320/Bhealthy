package com.Bhealthy.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.Bhealthy.user.domain.User;

@Mapper
public interface UserMapper {

	public User selectUserByLonginId(String loginId);
	
}

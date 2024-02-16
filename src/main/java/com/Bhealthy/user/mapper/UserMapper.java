package com.Bhealthy.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Bhealthy.user.domain.User;

@Mapper
public interface UserMapper {

	public User selectUserByLonginId(String loginId);
	
	public User selectUserByLoginIdAndPassword(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	public void insertUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email") String email);
	
	public User selectUserById(int id);
	
	
}

package com.Bhealthy.user.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
	private int id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private Date createdAt;
	private Date updatedAt;
	
//	 // test를 위한 생성자
//	public User(String loginId, String password) {
//		this.loginId = "test";
//		this.password = "test";
//	}

}

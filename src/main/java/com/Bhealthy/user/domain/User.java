package com.Bhealthy.user.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
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
	
	public static class JoinUser {

		private String loginId;
		private String password;
		private String name;
		private String email;

		public JoinUser(User user) {
		    this.loginId = user.getLoginId();
		    this.password = user.getPassword();
		    this.name = user.getName();
		    this.email = user.getEmail();
			}
	}
}

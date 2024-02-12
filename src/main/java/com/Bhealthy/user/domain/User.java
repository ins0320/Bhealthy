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
	
}

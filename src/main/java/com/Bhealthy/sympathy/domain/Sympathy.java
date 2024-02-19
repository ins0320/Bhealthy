package com.Bhealthy.sympathy.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data // lombok
public class Sympathy {
	private int postId;
	private int userId;
	private Date createdAt;
	private Date updatedAt;
}

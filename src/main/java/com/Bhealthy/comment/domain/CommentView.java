package com.Bhealthy.comment.domain;

import com.Bhealthy.user.domain.User;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CommentView {

	// 댓글
	private Comment comment;
	
	// 댓글 작성자
	private User user;
}

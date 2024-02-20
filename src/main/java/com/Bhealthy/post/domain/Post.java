package com.Bhealthy.post.domain;

import java.util.List;

import com.Bhealthy.comment.domain.CommentView;
import com.Bhealthy.post.entity.PostEntity;
import com.Bhealthy.user.domain.User;

import lombok.Data;
import lombok.ToString;

// 글 별 댓글, 공감 가져오기

@ToString
@Data // lombok
public class Post {

	// 글 1개
	private PostEntity post;
	
	// 글쓴이 정보 ( 글 1개에 대한)
	private User user;
	
	// 공감 개수
	private int sympathyCount;
	
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledSympathy;
	
	// 댓글
	private List<CommentView> commentViewList;
}

package com.Bhealthy.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Bhealthy.comment.domain.Comment;

@Mapper
public interface CommentMapper {

	// 댓글 추가
	public void insertComment(@Param("postId") int postId, @Param("userId") int userId, @Param("content") String content);
	
	// 댓글 조회(postId)
	public List<Comment> selectCommentListByPostId(int postId);
	
	// 댓글 삭제(id)
	public void deleteComment(int id);
}

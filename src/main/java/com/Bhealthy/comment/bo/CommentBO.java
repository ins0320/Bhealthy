package com.Bhealthy.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.comment.domain.Comment;
import com.Bhealthy.comment.domain.CommentView;
import com.Bhealthy.comment.mapper.CommentMapper;
import com.Bhealthy.user.bo.UserBO;
import com.Bhealthy.user.domain.User;

@Service
public class CommentBO {

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private UserBO userBO;
	
	// input: postId, comment   output: X
	public void addComment(int postId, int userId, String content) {
		commentMapper.insertComment(postId, userId, content);
	}
	
	public void deleteComment(int id) {
		commentMapper.deleteComment(id);
	}
		
	
	// 글번호별 댓글 가져오기
	public List<CommentView> generateCommentViewListByPostId(int postId) {
		
		// 댓글 저장 리스트(댓글, 작성자 저장)
		List<CommentView> commentViewList = new ArrayList<>();
		
		// postId별 댓글
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
	
		for(Comment comment : commentList) {
			
			// CommentView 객체(댓글, 작성자 저장)
			CommentView commentView = new CommentView();
			
			// 댓글 (postId별)
			commentView.setComment(comment);
			
			// 댓글 작성자
			User user = userBO.getUserById(comment.getUserId());
			commentView.setUser(user);
			
			// 댓글 저장 리스트(댓글, 작성자 저장)에 저장
			commentViewList.add(commentView);
		}
		return commentViewList;
	}
	
}

package com.Bhealthy.sympathy.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhealthy.sympathy.mapper.SympathyMapper;


@Service
public class SympathyBO {
	
	@Autowired
	private SympathyMapper sympathyMapper;
	
	// input: postId  output: x
	public void SympathyToggle(int postId, int userId) {
		
		int sympathy = sympathyMapper.selectSympathyByPostIdOrUserId(postId, userId);
		
		// 공감 존재 -> 삭제
		if(sympathy > 0) {
			sympathyMapper.deleteSympathyByPostIdOrUserId(postId, userId);
		} else { // 공감 없음 -> 추가
			sympathyMapper.insertSympathy(postId, userId);
		}
		
	}
	
	// 좋아요 총 개수
	// input: postId  output: int
	public Integer getSympathyByPostId(int postId) {
		return sympathyMapper.selectSympathyByPostIdOrUserId(postId, null);
	}
}

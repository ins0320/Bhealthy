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
		
		int sympathy = sympathyMapper.selectSympathyCountByPostOrIdUserId(postId, userId);
		
		// 공감 존재 -> 삭제
		if(sympathy > 0) {
			sympathyMapper.deleteSympathyByPostIdOrUserId(postId, userId);
		} else { // 공감 없음 -> 추가
			sympathyMapper.insertSympathy(postId, userId);
		}
		
	}
	
	// 공감하기 총 개수
	// input: postId  output: int
	public int getSympathyByPostId(int postId) {
		return sympathyMapper.selectSympathyCountByPostOrIdUserId(postId, null);
	}
	
	public int getLikeCountByPostIdUserId(int postId, int userId) {
		return sympathyMapper.selectSympathyCountByPostOrIdUserId(postId, userId);
	}
	
	// input: postId, userId( null or ) output: boolean
	public boolean getsympathyCountByPostId(int postId, Integer userId) {
		// 비로그인이면 무조건 빈하트 => false
		if(userId == null) {
			return false;
		}
			
		// 로그인: 0보다 크면(1이면) 채운다, 그렇지 않으면 false
		return sympathyMapper.selectSympathyCountByPostOrIdUserId(postId, userId) > 0;
	}
	
	public void deleteLikeByPostId(int postId) {
		sympathyMapper.deleteSympathyByPostIdOrUserId(postId, null);
	}	
}

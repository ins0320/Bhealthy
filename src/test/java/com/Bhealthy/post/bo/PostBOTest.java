package com.Bhealthy.post.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.Bhealthy.post.domain.Post;
import com.Bhealthy.post.entity.PostEntity;
import com.Bhealthy.user.bo.UserBO;
import com.Bhealthy.user.domain.User;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
@Transactional
class PostBOTest {
	
	@Autowired
	private PostBO postBO;
	
	//@Test
	@DisplayName("글 추가하기")
	void 글추가() {
		log.info("@@@@@@ 글 추가 테스트");
		
		// given
		//input: userId, userLoginId, content, file  output:  Integer id(pk) 
		User user = new User();
		PostEntity postEntity = new PostEntity();
		
		user.setLoginId("aaaa");
		postEntity.setUserId(1);
		postEntity.setContent("add test");
		
		// when
		int rowCount = postBO.addPost(postEntity.getUserId(), user.getLoginId(), postEntity.getContent(),null);	
		
		// then
		if(rowCount == 1) {
			log.info("@@@@@ 글 추가 테스트 성공");
		}
	}
	@Test
	@DisplayName("글 삭제하기")
	void 글삭제() {
		log.info("@@@@@ 글 삭제 테스트");
		
		//given
		PostEntity postEntity = new PostEntity();
		
		postEntity.setId(1);
		postEntity.setUserId(1);
		
		// when
		postBO.deletePostByIdAndUserId(postEntity.getId(), postEntity.getUserId());
		
		// then
		log.info("@@@@@ 글 삭제하기 성공");
	}	
	

}

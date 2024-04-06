package com.Bhealthy.notice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.Bhealthy.notice.bo.NoticeBO;
import com.Bhealthy.notice.entity.NoticeEntity;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
class NoticeTest {

	@Autowired
	private NoticeBO noticeBO;


	//@Test
	@DisplayName("공지사항 작성하기")
	void 공지사항쓰기() {
		log.info("!!!!! 공지사항 작성하기 시작");
		
		//given
		NoticeEntity notice = new NoticeEntity();
		notice.setTitle("test");
		notice.setContent("test");
		
		//when
		noticeBO.addNotice(notice.getTitle(), notice.getContent());
		
		//then
		log.info("!!!!! 공지사항 작성 완료");
	}

	@Test
	@DisplayName("공지사항 삭제하기")
	void 공지사항삭제() {
		log.info("!!!!! 공지사항 삭제하기");
		
		// given
		NoticeEntity notice = new NoticeEntity();
		notice.setId(2);
		notice.setContent("test");
		notice.setTitle("test");
		
		// when
		noticeBO.deleteNotice(notice.getId());
		List<NoticeEntity> noticeList = noticeBO.getNoticeEntityById(notice.getId());
		int a =noticeList.size();
		
		// then
		assertTrue(a== 0);
		log.info("!!!!! 공지사항 삭제 완료");
	}	
	
		//@Test
		@DisplayName("공지사항 수정하기")
		void 공지사항수정() {
			log.info("!!!!! 공지사항 수정하기");
			
			// given
			NoticeEntity notice = new NoticeEntity();
			notice.setId(2);
			notice.setContent("test");
			notice.setTitle("test");
			
			// when
			noticeBO.updateNotice(2, "test2", "test2");
			List<NoticeEntity> noticeList = noticeBO.getNoticeEntityById(notice.getId());
			
			// then
			assertNotNull(noticeList);
			log.info("!!!!! 공지사항 수정 완료 " + noticeList);		
		
	}
}

package com.Bhealthy.notice.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Bhealthy.notice.entity.NoticeEntity;
import com.Bhealthy.notice.repository.NoticeRepository;

@Service
public class NoticeBO {

	@Autowired
	private NoticeRepository noticeRepository;
	
	// input: title,content   output: x
	public void addNotice(String title, String content) {
		
		NoticeEntity noticeEntity = noticeRepository.save(
					NoticeEntity.builder()
					.title(title)
					.content(content)
					.build()
				);

	}
	// input: postId  output: x
	public void deleteNotice(int id) {
		noticeRepository.deleteById(id);
	}
	
	// input: id,title,content  output: x
	public void updateNotice(int id, String title, String content) {
		NoticeEntity noticeEntity = noticeRepository.findById(id).orElse(null);
		if(noticeEntity != null) {
			noticeEntity = noticeEntity.toBuilder()
							.title(title)
							.content(content)
							.build();
			noticeEntity = noticeRepository.save(noticeEntity);			
		}
	}
	
	// input: x output: List<NoticeEntity>
	public List<NoticeEntity> getNoticeEntity(){
		List<NoticeEntity> notice = noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		return notice;
	}
	
	// input: id output: List<NoticeEntity>
		public List<NoticeEntity> getNoticeEntityById(int id){
			List<NoticeEntity> notice = noticeRepository.findAllById(id);
			return notice;
		}
}

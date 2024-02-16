package com.Bhealthy.post.bo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Bhealthy.common.FileManagerService;
import com.Bhealthy.post.domain.Post;
import com.Bhealthy.post.entity.PostEntity;
import com.Bhealthy.post.repository.PostRepository;
import com.Bhealthy.user.bo.UserBO;
import com.Bhealthy.user.domain.User;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	// input: userId, userLoginId, content, file  output:  Integer id(pk) 
	public Integer addUser(int userId, String userLoginId, String content, MultipartFile file) {
		
		// 이미지 업로드 (업로드할 이미지가 있을 때 업로드)
		String imagePath = null;
		if (file != null) {
			imagePath = fileManagerService.saveFile(userLoginId, file);
		}
		
		PostEntity postEntity = postRepository.save(
				PostEntity.builder()
					.userId(userId)
					.content(content)
					.imagePath(imagePath)
					.build()
				);	
		return postEntity == null ? null: postEntity.getId();
	}
	
	// input: userId, postId  output: List<PostEntity>
	public List<PostEntity> getPostEntityList() {
		return postRepository.findAll();
	}
	
	
	// input: userId (비로그인: null, 로그인: userId) output: List<Post>
	public List<Post> getPostViewList(int userId){
		
		// post 글 객체 리스트
		List<Post> postViewList = new ArrayList<>();
		
		// 글 목록 가져오기
		List<PostEntity> postList = getPostEntityList(); 
		
		// 글 목록 반복문 순회
		for(PostEntity post : postList) {
			
			// post 하나에 대응되는 하나의 view 만든다.
			Post postView = new Post();
			
			// 글 1개
			postView.setPost(post);
			
			// 글쓴이 정보 (비 로그인 시에도 보임, 삭제 버튼에 사용)
			User user = userBO.getUserById(post.getUserId());
			postView.setUser(user);
			
		}
				
		}
		
		
	}
}

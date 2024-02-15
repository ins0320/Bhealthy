package com.Bhealthy.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Bhealthy.common.FileManagerService;
import com.Bhealthy.post.entity.PostEntity;
import com.Bhealthy.post.repository.PostRepository;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
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
	
	// input: userId, postId  output: Post
	public List<PostEntity> getPostList() {
		return postRepository.findAll();
	}
}

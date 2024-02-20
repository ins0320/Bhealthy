package com.Bhealthy.post.bo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Bhealthy.comment.bo.CommentBO;
import com.Bhealthy.comment.domain.Comment;
import com.Bhealthy.comment.domain.CommentView;
import com.Bhealthy.common.FileManagerService;
import com.Bhealthy.post.domain.Post;
import com.Bhealthy.post.entity.PostEntity;
import com.Bhealthy.post.repository.PostRepository;
import com.Bhealthy.sympathy.bo.SympathyBO;
import com.Bhealthy.user.bo.UserBO;
import com.Bhealthy.user.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private SympathyBO sympathyBO;
	
	@Autowired
	private CommentBO commentBO;
	
	// 글 추가
	// input: userId, userLoginId, content, file  output:  Integer id(pk) 
	public Integer addPost(int userId, String userLoginId, String content, MultipartFile file) {
		
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
	
	// 글 삭제
	public void  deletePostByIdAndUserId(int id, int userId) {
		
		// 기존 글 가져오기
		PostEntity post = postRepository.findById(id).orElse(null);
		
		if (post == null) {
			log.error("[delete post] postId:{}, userId:{}", id, userId);
			return;
		}
		
		// 글 삭제
		postRepository.delete(post);

		// 이미지 있으면 삭제
		fileManagerService.deleteFile(post.getImagePath());
	}
	
	// 글 가져오기
	// input: userId, postId  output: List<PostEntity>
	public List<PostEntity> getPostEntityList() {
		return postRepository.findAll();
	}
	
	// id로 글 가져오기
	// input: userId, postId  output: List<PostEntity>
	public List<PostEntity> getPostEntityById(Integer id) {
		return postRepository.findAllById(id);
	}
	
	
	
	// 작성된 글 뿌리기
	// input: userId (비로그인: null, 로그인: userId) output: List<Post>
	public List<Post> generatePostViewList(Integer userId, Integer id){
		
		// post 글 객체 리스트 (최종)
		List<Post> postViewList = new ArrayList<>();
		
		// id별 글 목록 가져오기
		List<PostEntity> postEntityList = getPostEntityById(id);
		
		// 글 목록 반복문 순회
		for(PostEntity post : postEntityList) {
			
			// post 하나에 대응되는 하나의 view 만든다.
			Post postView = new Post();
			
			// 글 1개
			postView.setPost(post);
			
			// 글쓴이 정보 (비 로그인 시에도 보임, 삭제 버튼에 사용)
			User user = userBO.getUserById(post.getUserId());
			postView.setUser(user);
			
			// 공감 개수
			int sympathyCount = sympathyBO.getSympathyByPostId(post.getId());
			postView.setSympathyCount(sympathyCount);
			
			
			// 로그인된 사람이 좋아요를 했는지 여부(비로그인 사용자 고려)
			boolean filledLike = sympathyBO.getsympathyCountByPostId(post.getId(), userId);
			postView.setFilledSympathy(filledLike);
			
			
			// 댓글리스트( postId, userId)
			//commentBO
			List<CommentView> commentList = commentBO.generateCommentViewListByPostId(post.getId());
			
			postView.setCommentViewList(commentList);
			
			// 최종: postViewList에 postView를 넣는다.
			postViewList.add(postView);
			
		}
			
		return postViewList;
	}
		
		
	
}

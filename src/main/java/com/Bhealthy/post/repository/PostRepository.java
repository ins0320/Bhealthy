package com.Bhealthy.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhealthy.post.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer>  {

	// postId, userId로 post 조회하기
	public List<PostEntity> findAll();
}

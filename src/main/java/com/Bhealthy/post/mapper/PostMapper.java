package com.Bhealthy.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Bhealthy.post.domain.Post;

@Mapper
public interface PostMapper {

	public  List<Post> selectPostListBySort(int sort);
}

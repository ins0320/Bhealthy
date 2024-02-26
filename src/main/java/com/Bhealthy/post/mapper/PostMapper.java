package com.Bhealthy.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Bhealthy.post.domain.Post;
import com.Bhealthy.post.entity.PostEntity;

@Mapper
public interface PostMapper {

	public  List<PostEntity> selectPostListBySort(int sort);
}

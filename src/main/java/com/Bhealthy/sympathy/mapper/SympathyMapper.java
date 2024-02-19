package com.Bhealthy.sympathy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SympathyMapper {

	public Integer selectSympathyByPostIdOrUserId(@Param("postId") int postId, @Param("userId") Integer userId);
	
	public void insertSympathy(	@Param("postId") int postId, @Param("userId") int userId);
	
	public void deleteSympathyByPostIdOrUserId(@Param("postId") int postId,@Param("userId") int userId);
}

package com.Bhealthy.sympathy.mapper;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SympathyMapper {
	
//	public int selectSympathyCountByPostIdUserId(@Param("postId") int postId, @Param("userId") int userId);
//	
//	public int selectSympathyCountByPostId(int postId);
	
	public int selectSympathyCountByPostOrIdUserId(@Param("postId") int postId, @Param("userId") Integer userId);
	
	public void insertSympathy(	@Param("postId") int postId, @Param("userId") int userId);
	
	public void deleteSympathyByPostIdOrUserId(@Param("postId") int postId,@Param("userId") Integer userId);
}

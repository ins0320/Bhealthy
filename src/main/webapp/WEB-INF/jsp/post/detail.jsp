<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<div class="d-flex justify-content-center">
	<div class="contents-box">
	<%-- 커뮤니티 영역 --%>
		<div class="timeline-box my-5">
			
			<%-- 글 1개 --%>
			<div class="card border rounded mt-3">
			<c:forEach items="${postViewList}" var="postView">
				<%-- 글쓴이, 더보기(삭제) --%>
				<div class="p-2 d-flex justify-content-between">
					<span class="font-weight-bold">${postView.user.loginId}</span>
					
					<%-- (더보기 ... 버튼) 로그인 된 사람과 글쓴이 정보가 일치할 때 노출 --%>
					...
				</div>	
				
				<%-- 커뮤니티 이미지 --%>
				<div class="post-img">
					이미지
				</div>
				
				<%-- 공감하기 --%>
				<div class="post-like m-3">
					공감하기
				</div>
				
				<%-- 글 내용 --%>
				<div class="post-content m-3">
					<span>${postView.post.content}</span>
				</div>
			</c:forEach>	
				<%-- 댓글 제목 --%>
				<div class="post-comment-desc border-bottom">
					<div class="ml-3 mb-1 font-weight-bold">댓글</div>
				</div>
				
				<%-- 댓글 목록 --%>
				<div class="post-comment-list m-2">
					댓글들
					
					<%-- 댓글 쓰기 --%>
					<div class="post-comment-write d-flex border-top mt-2">
						<input type="text" class="form-control border-0 mr-2 comment-input" placeholder="댓글 달기"/> 
						<button type="button" class="comment-btn btn btn-light">게시</button>
					</div>
				</div> <%--// 댓글 목록 끝 --%>
			</div> <%--// 글 1개 끝 --%>
			
		</div><%--// 커뮤니티 영역 끝  --%>
	</div> <%--// contents-box 끝  --%>
</div>	
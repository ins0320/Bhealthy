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
					<c:if test="${userId eq postView.post.userId}">
					<a href="#" class="more-btn" data-toggle="modal" data-target="#modal" data-post-id="${postView.post.id}">
						<img src="https://www.iconninja.com/files/860/824/939/more-icon.png" width="30">
					</a>
					</c:if>
				</div>	
				<%-- 커뮤니티 이미지 --%>
				<div class="post-img">
					<img src="${postView.post.imagePath}" class="w-100" alt="본문 이미지">
				</div>
				
				<%-- 공감하기 --%>
				<div class="post-sympathy m-3">
				<c:if test="${postView.filledSympathy eq false}">
					<a href="#" class="sym-btn" data-post-id="${postView.post.id}">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-chat-square-heart" viewBox="0 0 16 16">
					 	 <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
					 	 <path d="M8 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
						</svg>
					</a>
				</c:if>	
				<c:if test="${postView.filledSympathy eq true}">
					<a href="#" class="sym-btn" data-post-id="${postView.post.id}">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-chat-square-heart-fill" viewBox="0 0 16 16">
						  <path d="M2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm6 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
						</svg>
					</a>	
				</c:if>	
					공감 ${postView.sympathyCount}개
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



<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<%-- 
		modal-sm: 작은 모달창 
		modal-dialog-centered: 수직 기준 가운데 위치
	--%>
	<div class="modal-dialog modal-sm modal-dialog-centered">
		<div class="modal-content text-center">
			<div class="py-3 border-bottom">
    			<a href="#" id="postDelete">삭제하기</a>
    		</div>
			<div class="py-3">
    			<a href="#" data-dismiss="modal">취소하기</a>
    		</div>
		</div>
	</div>
</div>


<script>
	$(document).ready(function() {
		
		
		// 더보기(...) 클릭 => 모달 띄우기
		$(".more-btn").on('click', function(e) {
			e.preventDefault(); // a 태그 올라가는 현상 방지
			
			let postId = $(this).data("post-id"); // getting
			//alert(postId);
			
			// 1개로 존재하는 모달에 재활용을 위해 data-post-id를 심는다.
			$("#modal").data("post-id", postId); // setting
		});	
		
		// 모달 안에 있는 삭제하기 클릭
		$("#modal #postDelete").on('click', function(e) {
			e.preventDefault(); // a 태그 위로 올라가는 현상 방지
			
			let postId = $("#modal").data("post-id");
			//alert(postId);
			
			// 글 삭제
			$.ajax({
				type:"delete"
				, url:"/post/delete"
				, data: {"id":postId}
				, success: function(data) {
					if (data.code == 200) {
						location.reload(true);
					} else {
						alert(data.error_message);
					}
				}
				, error: function(e) {
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
			
		}); // ---- modal
		
		$(".sym-btn").on('click', function(e){
			e.preventDefault();
			// alert("공감");
			
			let postId = $(this).data("post-id");
			// alert(postId);
			
			$.ajax({
				url:"/sympathy/" + postId
				, success:function(data) {
					if (data.code == 200) {
						// 성공
						location.reload(true); // 새로고침 => timeline view화면
					} else if (data.code == 300) {
						// 비로그인 시 로그인 페이지로 이동
						alert(data.error_message);
						location.href = "/user/sign-in-view";
					}
				}	
				, error:function(request, status, error) {
						alert("좋아요를 하는데 실패했습니다.");
				}	
			});
		}); // ---- sympathy
	}); //----- document
</script>
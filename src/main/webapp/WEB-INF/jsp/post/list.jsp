<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 부트스트랩 cdn --> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<div class="mt-5">
		<div class="d-flex ml-5" >			
			<button type="button" class="btn-secondary post-list-btn latelyBtn" id="latelyBtn" data-sort-id="1">최신순 <i class="bi bi-arrow-repeat"></i> </button>
			<button type="button" class="beige-color post-list-btn black-color popularityBtn" data-sort-id="2">공감순 
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-square-heart" viewBox="0 0 16 16">
 					<path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
 					<path d="M8 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132"/>
				</svg> 
			</button>
			<button type="button" class="btn-info post-list-btn commentBtn" data-sort-id="3">댓글순 <i class="bi bi-chat-dots"></i></button>
		
		</div>
	<table class="table text-center">
 			<thead>
 				<tr>
		 			<th>No.</th>
		 			<th>제목</th>
		 			<th>아이디</th>
		 			<th>작성날짜</th>
 				</tr>
 			<tbody> 		
 			<c:forEach items="${postList}" var="post">
 				<tr>
 					<td>${post.id }</td>
 					<td><a href="/post/detail-view?id=${post.id}">${post.content }</a></td>
 					<td>${post.userId}</td>
 					<td><fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd"/></td>
 				<br>
 				</tr>
 			</c:forEach>	
 			</tbody>	
 	</table>
 	<div class="d-flex justify-content-end mt-2">
	 	<a href="/post/create-view" class="btn btn-info">작성하기</a>
	</div>
</div>	
<script>
$(document).ready(function(){
	
		// 최신순
		$("#latelyBtn").on('click', function(e){
			e.preventDefault;
			// alert("최신순");
			let sortId = $(this).data("sort-id");
			// alert(sortId);
	 		 $.ajax({
				url: "/post/list-view/" + sortId
				, success: function(data){
					if (data.code == 200) {
						// 성공
						location.reload(true);
					} 
				}	
				, error:function(request, status, error) {
					alert("최근순으로 정렬하는데 실패했습니다.");
				}	
			});
			
		}); // ---- latelyBtn
		
		/* $(".popularityBtn").on('click'), function(e){
			e.preventDefault;
			let sortId = $(this).data("sort-id");
			
			$.ajax({
				url: "/list-view/" + sortId
				, success:function(data){
					if (data.code == 200) {
						// 성공
						location.reload(true);
					} 
				}	
				, error:function(request, status, error) {
					alert("인기순으로 정렬하는데 실패했습니다.");
				}
			
			}); 
		});// ---- popularityBtn

		$(".commentBtn").on('click'), function(e){
			e.preventDefault;
			let sortId = $(this).data("sort-id");
			
			$.ajax({
				url: "/list-view/" + sortId
				, success:function(data){
					if (data.code == 200) {
						// 성공
						location.reload(true);
					} 
				}	
				, error:function(request, status, error) {
					alert("추천순으로 정렬하는데 실패했습니다.");
				}	
		}); // ---- popularityBtn 
	}); */
});	
</script>	
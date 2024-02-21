<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:forEach items="${noticeList}" var="notice">
	<div class="d-flex mt-5">
		<h3>제목</h3>
		<h3><input type="text" class="form-control col-11 ml-3" id="title" value="${notice.title}"></h3>		
	</div>
	<textarea rows="5" class="form-control mt-2 col-11" id="contentInput">${notice.content}</textarea>
 <div class="d-flex justify-content-end mt-5">
 	<button type="button" class="btn btn-danger mr-3" id="deleteBtn" data-post-id="${notice.id}">삭제하기</button>
 	<button type="button" class="btn btn-secondary mr-3" id="updateBtn" data-post-id="${notice.id}">수정하기</button>
 	<button type="button" class="btn btn-secondary mr-3" id="clearBtn" data-post-id="${notice.id}">모두 지우기</button>
	<a href="/admin/notice/list" class="btn btn-info mr-5">목록으로</a>
 </div>
 </c:forEach>	
 <script>
	 $(document).ready(function(){
		 $("#deleteBtn").on('click', function(e){
			 e.preventDefault;
			 // alert("삭제하기");
			 let postId = $(this).data("post-id");
			 // alert(postId);
			 
			 // 글 삭제
			$.ajax({
				type:"delete"
				, url:"/admin/notice/delete"
				, data: {"postId":postId}
				, success: function(data) {
					if (data.code == 200) {
						alert("글이 삭제됐습니다.");
						location.href="/admin/notice/list";
					} else {
						alert(data.error_message);
					}
				}
				, error: function(e) {
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			}); 
		 }); // ---- 삭제하기
		 
		 
	 }); // ---- document
 
 </script>
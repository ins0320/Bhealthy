<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50 mt-5">
		<h1>공지사항</h1>
		<br>
		<input type="text" class="form-control title" placeholder="제목을 입력하세요">
		<textarea id="content" class="form-control mt-3 content" placeholder="내용을 입력하세요" rows="10"></textarea>
		
		<div class="d-flex justify-content-between">
			<a href="/admin/notice/list"class="btn btn-dark">목록</a>
			
			<div>
				<button type="button" id="updateBtn" class="btn btn-secondary">수정</button>
				<button type="button" id="clearBtn" class="btn btn-danger">삭제</button>
				<button type="button" id="saveBtn" class="btn btn-info">저장</button>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		$("#saveBtn").on('click', function(e){
			e.preventDefault;
			// alert("공지사항");
			
			let title = $(".title").val().trim();
			let content = $(".content").val().trim();
			//alert(title);
			
			// validation
			if(! title){
				alert("제목을 입력해주세요");
				return;
			}
			if(! content){
				alert("내용을 입력해주세요.");
				return;
			}
		
			$.post("/admin/notice/create", {"title":title, "content":content})// request
			.done(function(data) { // response
				if (data.code == 200) {
					location.href="/admin/notice/list-view";
				} else{
					alert(data.error_message);
				}
			});
		}); // ---- saveBtn
		
	}); // ---- document
		

</script>	
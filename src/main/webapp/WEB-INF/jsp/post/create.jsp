<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="w-50 mt-5">
		<h1>게시글 작성하기</h1>
		
		<textarea id="content" class="form-control mt-3" placeholder="내용을 입력하세요" rows="10"></textarea>
		
		<div class="d-flex justify-content-end my-3">
			<input type="file" id="file" accept=".jpg, .png, .gif, .jpeg">
		</div>
		
		<div class="d-flex justify-content-between">
			<a href="/notice/list-view" class="btn btn-dark">목록</a>
			<div>
				<button type="button" id="clearBtn" class="btn btn-secondary">모두 지우기</button>
				<button type="button" id="saveBtn" class="btn btn-info">저장</button>
			</div>
		</div>
	</div>
</div>	
<script>
	$(document).ready(function(){
		// alert("게시글 작성");
		
		// 모두 지우기 버튼 클릭 
		$("#clearBtn").on('click', function() {
			//alert("모두 지우기");
			$("#content").val("");
			$("#file").val("");
		});
		
		// 저장하기
		$("#saveBtn").on('click', function(){			
			let file = $("#file").val(); // C:\fakepath\Lenna.png
			let content = $("#content").val();
			
			//alert(file);
			
			if(!content){
				alert("내용을 입력하세요.");
				return;
			}
		
			// 파일이 업로드 된 경우에만 확장자 체크
			if(file) {
				// alert("파일이 업로드 됐다.");
				// alert(file);  // C:\fakepath\Lenna.png
				let extension = file.split(".").pop().toLowerCase(); //png
				// alert(extension);
				
				if ($.inArray(extension, ['jpg', 'png', 'gif', 'jpeg']) == -1) {
					alert("이미지 파일만 업로드 할 수 있습니다.");
					$("#file").val(""); // 파일을 비운다.
					return;
				}
			}
			
			//alert(file);
			// form 태그를 js에서 만든다.
			// 이미지를 업로드 할 때는 반드시 form 태그가 있어야 한다.
			let formData = new FormData();
			formData.append("content", content);
			formData.append("file", $("#file")[0].files[0])
			
			$.ajax({
				// request
				type:"POST"
				, url:"/post/create"
				, data: formData
				, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
				, processData:false // 파일 업로드를 위한 필수 설정
				, contentType:false // 파일 업로드를 위한 필수 설정
				
				//response
				, success: function(data){
					if (data.code == 200) {
						alert("글이 저장되었습니다.");
						location.href ="/post/list-view/1";
					} else {
						alert(data.error_message);
					}
				}
			, error: function(request, status, error){
				alert("글을 저장하는데 실패했습니다.");
			}
					
			});
			
		});
		
	});

</script>
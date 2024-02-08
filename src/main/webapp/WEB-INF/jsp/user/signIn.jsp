<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
		<div>
			<img src="/static/css/images/main.png" class="mt-3">
		</div>
		<div class="sign-in-box d-flex justify-content-center align-items-center bg-white border rounded mt-3">
				<form id="loginForm" action="/user/sign-in" method="post">	 	 
		 	 		<input type="text" id="loginId" class="form-control" placeholder="아이디">
		 	 		<input type="password" id="password" class="form-control mt-4" placeholder="비밀번호">
		 	 		<button type="submit" id="loginBtn" class="btn btn-secondary btn-block mt-4">로그인</button>
		 	 		<hr>
						<a href="/user/sign-up-view" class="italic">가입하기</a>
		 		</form>
		 	</div>
</div>
<script>
	$(document).ready(function(){
		$("#loginBtn").on('click', function(e){
			// alert("로그인 버튼 입니다.");
			e.preventDefault(); // submit 기능 막음
			
			let loginId = $("#loginId").val().trim();
			let password = $("#password").val().trim();
			
			// validation
			if(!loginId){
				alert("아이디를 입력해주세요.");
				return false;
			}
			
			if(!password){
				alert("비밀번호를 입력해주세요.");				
				return false;
			}
			
			$.post("/user/sign-in", {"loginId":loginId, "password":password}) // request
			.done(function(data){  //response
				if(data.code == 200){
					alert("환영합니다.");
					location.href="/post/main-view";
				} else if(data.code == 300){
					alert(data.error_message);
				} else{
					alert("로그인에 실패했습니다. 관리자에게 문의하세요.")
				}
			});
			
		});
		
	}); // ----- document
</script>
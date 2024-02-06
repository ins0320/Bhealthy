<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center">
	<div class="sign-up-box">
		<div class="title">Bhealthy</div>
		<div class="mt- ml-2"> Bhealthy 회원 서비스 입니다.</div>
		<form id="signUpForm" method="post" action="/user/sign-up">
			<div class="mt-4"></div>
			<span class="sign-up-subject">*아이디</span>
			<div class="d-flex ml-3 mt-3">
				<input type="text" id="loginId" name="loginId" class="form-control col-6" placeholder="ID를 입력해주세요">
				<button type="button" id="loginIdCheckBtn" class="btn btn-success ml-3">중복확인</button>
			</div>
			
			<%-- 아이디 체크 결과 --%>
			<div class="ml-3 mb-3">
				<div id="idCheckLength" class="small text-danger d-none">ID를 4자 이상 입력해주세요.</div>
				<div id="idCheckDuplicated" class="small text-danger d-none">이미 사용중인 ID입니다.</div>
				<div id="idCheckOk" class="small text-success d-none">사용 가능한 ID 입니다.</div>
			</div>
			
			<span class="sign-up-subject">*비밀번호</span>
			<div class="m-3">
				<input type="password" id="password" name="password" class="form-control col-6" placeholder="비밀번호를 입력하세요">
			</div>

			<span class="sign-up-subject">*Confirm password</span>
			<div class="m-3">
				<input type="password" id="confirmPassword" name="confirmPassword" class="form-control col-6" placeholder="비밀번호 확인을 입력하세요">
			</div>

			<span class="sign-up-subject">*이름</span>
			<div class="m-3">
				<input type="text" id="name" name="name" class="form-control col-6" placeholder="이름을 입력하세요">
			</div>

			<span class="sign-up-subject">*이메일</span>
			<div class="m-3">
				<input type="text" id="email" name="email" class="form-control col-6" placeholder="이메일을 입력하세요">
			</div>
			
			<br>
			<div class="d-flex  m-3">
				<button type="submit" id="signUpBtn" class="btn btn-info">가입하기</button>
			</div>
		</form>
	</div>
</div>
<script>
	$(document).ready(function(){
		
		// 아이디 중복확인
		$("#loginIdCheckBtn").on('click', function(){
			// alert("아이디 중복확인");
			
			
			// 경고 문구 초기화
			$("#idCheckLength").addClass("d-none");
			$("#idCheckDuplicated").addClass("d-none");
			$("#idCheckOk").addClass("d-none");
			

			let loginId = $("#loginId").val().trim();
			if(loginId.length< 4){
				$("#idCheckLength").removeClass("d-none");	
				return;
			}
			
			$.get("/user/is-duplicated-id", {"loginId": loginId}) // request
			.done(function(data){
				if(data.code == 200){ // success
					if(data.is_duplicate){ // 중복
						$("#idCheckDuplicated").removeClass("d-none");
					} else { // 중복 아님 (사용가능)
						$("#idCheckOk").removeClass("d-none");
					}
				} else {	// fail
					alert(data.error_message);
				}
			}); // response
		}); // -- 아이디 중복확인
		
		// 회원가입
		$("#signUpBtn").on('click', function(e){
			//alert("회원가입 버튼");
			
			e.preventDefault(); // submit 기능 막음
			
			let loginId = $("#loginId").val().trim();
			let password = $("#password").val().trim();
			let confirmPassword = $("#confirmPassword").val().trim();
			let email = $("#email").val().trim();
			let name = $("#name").val();
			
			
			// validation
			if(!loginId){
				alert("아이디를 입력해주세요.");
				return false;
			}
			
			if(!password){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			if(!confirmPassword){
				alert("비밀번호 확인을 입력해주세요.");
			}
			
			if(password != confirmPassword){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			if(!name){
				alert("이름을 입력해주세요.");
				return false;
			}
			
			if(!email){
				alert("이메일을 입력해주세요.");
				return false;
			}
		
			// 중복확인 후 사용 가능한 아이디인지 확인
			// => idCheckOk 클래스 d-none이 없을 때
			if ($("#idCheckOk").hasClass('d-none')) {
				alert("아이디 중복확인을 다시 해주세요.");
				return false;
			}
			
			$.post("/user/sign-up", {"loginId":loginId, "password":password, "confirmPassword":confirmPassword, "email":email, "name":name}) // request
			.done(function(data){
				if(data.code == 200){
					alert("가입을 환영합니다.");
					location.href="/user/sign-in-view";
				} else{
					alert("가입에 실패했습니다. 관리자에게 문의해주세요.");
				}
			})
			
		}); // ---- #signUpBtn
		
		
	}); // ---- document
</script>
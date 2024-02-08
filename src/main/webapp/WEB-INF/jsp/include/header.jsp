<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="h-100 d-flex justify-content-between align-items-center">
		<div class="title font-color">Bhealthy</div>
		<!-- 로그인 -->
		<c:if test="${not empty userId }">
			<span>${userName}님 안녕하세요.</span>
			<a href="user/sign-out">로그아웃</a>
		</c:if>
		<!-- 비 로그인 -->
		<c:if test="${empty uesrId }">
			<a href="/user/sign-in-view">로그인</a>
		</c:if>	
	</div>
</body>
</html>
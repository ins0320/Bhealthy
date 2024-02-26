<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
	<nav>
		<ul class="nav nav-fill">
			<li class="nav-item "><a href="/post/main-view" class="nav-link nav-text">Home</a></li>
			
			<!--  최신순, 공감순, 댓글순으로 리스트 목록 정렬하기 -->
			<li class="nav-item ">
			<c:if test="${sortId == 1 }">
				<a href="/post/list-view/1" class="nav-link nav-text fromLeft:after">커뮤니티</a>
			</c:if>
			<c:if test="${sortId == 2 }">
				<a href="/post/list-view/2" class="nav-link nav-text fromLeft:after">커뮤니티</a>
			</c:if>
			<c:if test="${sortId == 3 }">
				<a href="/post/list-view/3" class="nav-link nav-text fromLeft:after">커뮤니티</a>
			</c:if>
			</li>

			<li class="nav-item "><a href="#" class="nav-link nav-text">예약하기</a></li>
			<li class="nav-item "><a href="/notice/list-view" class="nav-link nav-text">공지사항</a></li>
		</ul>
	</nav>

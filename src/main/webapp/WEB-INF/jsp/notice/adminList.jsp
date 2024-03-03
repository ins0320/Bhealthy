<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 부트스트랩 cdn --> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<div class="mt-5">
	<table class="table text-center">
 			<thead>
 				<tr>
		 			<th>No.</th>
		 			<th>제목</th>
		 			<th>작성자</th>
		 			<th>작성날짜</th>
 				</tr>
 			<tbody> 		
 			<c:forEach items="${noticeList}" var="notice">
 				<tr>
 					<td>${notice.id }</td>
 					<td><a href="/admin/notice/detail-view?id=${notice.id}">${notice.title}</a></td>
 					<td>관리자</td>
 					<td><fmt:formatDate value="${notice.createdAt}" pattern="yyyy-MM-dd"/></td>
 				<br>
 				</tr>
 			</c:forEach>	
 			</tbody>	
 	</table>
 	<div class="adminCreateNotice mr-5">
 		<a href="/admin/notice/create-view">작성하기</a>
 	</div>
</div>	
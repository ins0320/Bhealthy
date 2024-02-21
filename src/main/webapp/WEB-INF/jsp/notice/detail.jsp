<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<div class="d-flex mt-5">
		<label><h4>제목</h4></label>
		<c:forEach items="${noticeList}" var="notice">
		 	<!-- 관리자일 경우만 form 작성 가능 -->
		 	<c:choose>
				 <c:when test="${userName eq 'admin'}">
				 		<h2><input type="text" class="form-control col-11 ml-3" id="title" value="${notice.title}"></h2>		
				 </c:when>
				 					
				 <c:otherwise>
				 	<h2 class="ml-3">${notice.title}</h2>
				 </c:otherwise>
		 	</c:choose>
			</div>
	 		<hr class="hr-solid">
	 		<!-- 관리자일 경우만 form 작성 가능 -->
		 	<c:choose>
		 		<c:when test="${userName eq 'admin'}">
		 			<textarea rows="5" class="form-control mt-2 col-11" id="contentInput">${notice.content}</textarea>
		 		</c:when>
		 		<c:otherwise>
		 			<pre>${notice.content}</pre>
		 		</c:otherwise>
		 	</c:choose>	
		</c:forEach>	
 <div class="d-flex justify-content-end mt-5">
 	<c:if test="${userLoginId eq 'admin' }">
 		<button type="button" class="btn btn-info" id="saveBtn" data-post-id="${notice.id}">저장하기</button>
	</c:if>
	<a href="/post/notice/list/view" class="btn btn-info">목록으로</a>
 </div>
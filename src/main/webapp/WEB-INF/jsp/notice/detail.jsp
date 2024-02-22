<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:forEach items="${noticeList}" var="notice">
	<br>
	<hr class="hr-solid">
	<div class="d-flex">
		<h3 class="ml-5">제목:</h3>
		<h3 class="ml-3">${notice.title}</h3>	
	</div>
	<hr>
	<pre class="ml-5 notice-text">${notice.content}</pre>
</c:forEach>	
 <div class="d-flex justify-content-end mt-5 mr-5">
	<a href="/notice/list-view" class="btn btn-info">목록으로</a>
 </div>
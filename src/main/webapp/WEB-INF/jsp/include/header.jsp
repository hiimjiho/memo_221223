<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>
	<div class="mt-2">
		<h1>MEMO 게시판</h1>
	</div>
	
	<div class="logout">
		<c:if test="${not empty userId}">
			<span class="mr-3">${userName}님 안녕하세요</span>
			<a href="/user/sign_out" class="font-weight-bold">로그아웃</a>
		</c:if>
		<c:if test="${empty userId">
			<a href="/user/sign_in_view" class="font-weight-bold"></a>
		</c:if>
	</div>
</div>



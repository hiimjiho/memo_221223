<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMO 메모</title>
<!-- bootstrap -->

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<!-- bundle slim제거 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<!-- css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<!-- 내가 만든 스타일시트 -->
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
	<div id="wrap">
		<header class="bg-secondary">
			<jsp:include page="../include/header.jsp" /><!-- ..은 내가 있는 폴더에서 위로 올라가는 것. 앞에 /가 붙지 않았으므로 상대경로이다. -->
		</header>
		<section class="contents">
			<jsp:include page="../${view}.jsp" />
		</section>
		<footer class="bg-secondary">
			<jsp:include page="/WEB-INF/jsp/include/footer.jsp" /> <!-- 절대경로 -->
		</footer>
	</div>
</body>
</html>
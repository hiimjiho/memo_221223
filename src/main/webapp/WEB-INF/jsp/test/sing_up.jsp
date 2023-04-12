<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
    <title>회원가입</title>
</head>
<body>
    <div class="container">
        <h1>회원가입</h1>
       <span>아이디</span>
        <div class="form-group">
        <input class="form-control col-6" name="loginId"><button class="btn btn-success">중복확인</button>
        </div>

        <span>비밀번호</span>
        <div class="form-group">
        <input class="form-control col-6" name="password" type="text">
        </div>

        <span>비밀번호 확인</span>
        <div class="form-group">
        <input class="form-control col-6" name="password" type="text">
        </div>

        <span>이름</span>
        <div class="form-group">
        <input class="form-control col-6" name="name" type="text">
        </div>

        <span>이메일 주소</span>
        <div class="form-group">
        <input class="form-control col-6" name="email" type="text">
        </div>

        <button class="btn btn-info">회원가입</button>
    </div>
</body>
</html>
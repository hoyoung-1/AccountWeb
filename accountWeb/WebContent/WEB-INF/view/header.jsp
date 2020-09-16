<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/resouces/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/resouces/css/header.css" />
</head>
<body>

	<header>
		<div class="header-container">
			<div class="logo-block">
				<a href="/home">
					<img class="logo-img" src="/resouces/img/logo.jpg" alt="이미지 없음" />
				</a>
			</div>
			<c:if test="${empty user }">
				<div class="user-info">
					<a href="/user/login">로그인 </a> | <a href="/user/add">회원가입</a>
				</div>
			</c:if>
			<c:if test="${not empty user }">
			<form action="/home" method="post" onsubmit="logout()">
				<div class="user-info">
					${user.name }님  | <input type="submit" value="로그아웃"/>
				</div>
			</form>
			</c:if>
		</div>

		<nav>
			<div class="nav-list">
				<a href="account">가계부</a> <a href="notice">공지사항</a> <a href="tip">팁
					게시판</a>
			</div>
		</nav>

	</header>
	
	<script>
	
	function logout() {
		alert("로그아웃 되었습니다.");
		
	}
	</script>

</body>
</html>
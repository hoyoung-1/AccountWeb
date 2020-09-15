<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resouces/css/header.css" />
<link rel="stylesheet" type="text/css" href="/resouces/css/reset.css" />
</head>
<body>
<header>
		<div class="content-container header">
			<span class="logo"> <a href="home"><img class="logo-img"
					src="/resouces/img/logo.jpg" alt="이미지 없음" /> </a>
			</span>
			<c:if test="${empty login }">
				<span class="user-info"> <a href="login">로그인 </a> | <a
					href="add">회원가입</a>
				</span>
			</c:if>
			<c:if test="${not empty login} }">
				<span class="user-info"> <a href="login">로그인 </a> | <a
					href="add">회원가입</a>
				</span>
			</c:if>
		</div>
		
		<nav>
			<div class="nav-list">
				<a href="account">가계부</a>
				<a href="notice">공지사항</a>
				<a href="tip">팁 게시판</a>
			</div>
		</nav>

	</header>
</body>
</html>
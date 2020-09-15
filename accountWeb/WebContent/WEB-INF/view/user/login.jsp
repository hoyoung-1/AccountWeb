<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 로그인 --</title>
<link rel="stylesheet" href="/resouces/css/user/login.css"/>
</head>
<body>
	<c:if test="${error }">
		<script>
			alert("아이디, 비밀번호가 틀렸습니다.");
		</script>
	</c:if>

	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<c:if test="${flag }">
		<script>
			alert("회원 가입되셨습니다. 로그인 해주세요.");
		</script>
	
	</c:if>


	<main role="main">

		<div class="login-container">
			<div class="login-title">로그인</div>
			<form action="/user/login" method="post">
				<div class="login-input-block">
					<label>id</label><input type="text" name="id" />
				</div>
				<div class="login-input-block">
					<label>pw</label><input type="text" name="pw" />
				</div>

				<div class="login-button-block">
					<input type="submit" value="로그인" /> <input type="button"
						value="회원가입" />
				</div>
			</form>
		</div>

	</main>



	<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>

</body>
</html>
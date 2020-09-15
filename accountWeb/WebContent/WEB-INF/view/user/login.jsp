<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 로그인 --</title>
<link rel="stylesheet" href="/resouces/css/user/login.css"/>
</head>
<body>

	<jsp:include page="/WEB-INF/view/header.jsp"/>


	<main role="main">

		<div class="login-container">
			<div class="login-title">로그인</div>
			<form action="login" method="post">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>--회원가입--</title>
<link rel="stylesheet" href="/resouces/css/user/add.css" />
</head>
<body>

	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role="main">
		<div class="add-container">
			<div class="add-block">
				<div class="add-title">회원가입</div>
				
				<form action="/user/add" method="post">
					<label>ID</label> <input type="text" name="addID" />
					<label>PW</label> <input type="text" name="addPW" />
					<label>CHECK</label> <input type="text" />
					<label>NAME</label> <input type="text" name="addName" />
				</form>
			</div>
		</div>
	
	
	</main>



	<jsp:include page="/WEB-INF/view/footer.jsp" />

</body>
</html>
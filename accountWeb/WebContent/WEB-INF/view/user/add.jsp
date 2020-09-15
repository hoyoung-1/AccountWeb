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
			<div class="add-title">회원가입</div>
			<form action="/user/add" method="post">
				<div class="add-block">
				
					<div class="input-block"><label>ID</label> <input type="text" name="addID" /> </div>
					<div class="input-block"><label>PW</label> <input type="text" name="addPW" /></div> 
					<div class="input-block"><label>CHECK</label> <input type="text" /> </div>
					<div class="input-block"><label>NAME</label> <input type="text" name="addName" /></div>
					<div class="input-block add-btn"><input type="submit" value="회원가입" /></div>
				</div>
			</form>
			</div>
	
	
	</main>



	<jsp:include page="/WEB-INF/view/footer.jsp" />

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 등록 --</title>
<style>
.add-container {
	width: 80%;
	margin: auto;
}

.table-block {
	width: 100%;
	margin: auto;
	text-align: center;
}

#noticeContent {
	resize: none;
	width: 100%;
	height: 500px;
	border: none;
}

#noticeContent:focus {
	outline: none;
}

tr {
	border: 1px solid !important;
}

td {
	padding: 10px !important;
}

input[type=text] {
	width: 100%;
	border: none;
	font-size: 20px;
}

input[type=text]:focus{

	outline: none;
}



</style>
</head>
<body>
<c:if test="${empty user }">
	<script>
		alert("잘못된 접근입니다.");
		location.href="/home";
	</script>
</c:if>
<c:if test="${not empty error }">
	<script>
		alert("입력에 실패하였습니다.");
	</script>
</c:if>


	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role="main">
		<div class="add-container">
			<form action="/notice/add" method="post" >
				<table class="table-block">
					<tbody>
						<tr>
							<td>작성자</td>
							<td><input type="text" disabled="disabled" name="writer"
								value="kpw521" /></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" /></td>
						</tr>
						<tr>
							<td colspan="2">내용</td>
						</tr>
						<tr>
							<td colspan="2">
							<textarea name="content" id="noticeContent" cols="30" rows="10"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="등록" />
			</form>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />


</body>
</html>
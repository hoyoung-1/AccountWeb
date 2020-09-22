<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 등록 --</title>

<link rel="stylesheet" href="/resouces/css/notie/add.css" />
<!-- summer note api -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
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
							<textarea name="content" id="summernote" class='summernote' cols="30" rows="10"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="등록" />
			</form>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />

<script>
	$('#summernote').summernote({
		maxHeight: "500px",
		minHeight: "500px",
	});
</script>

</body>
</html>
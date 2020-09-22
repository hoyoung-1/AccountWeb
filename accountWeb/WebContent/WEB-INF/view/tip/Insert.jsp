<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- summer note api -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<style>
.insert-container{
	width: 80%;
	margin: auto;
}

.table-block{
	margin: auto;
	width: 100%;
	text-align: center;
}


</style>

</head>
<body>

	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role="main">
		<div class="insert-container">
			<form action="/tip/insert" method="post" >
				<table class="table-block">
					<tbody>
						<tr>
							<td>작성자</td>
							<td><input type="text" disabled="disabled" name="writer"
								value="${user.id }" /></td>
						</tr>
						<tr>
							<td colspan="2">
						</tr>
						<tr>
							<td>제목</td>
							<td><input type="text" name="title" /></td>
						</tr>
						<tr>
							<td colspan="2">
							<textarea name="content" class="summernote" id="summernote" cols="30" rows="10"></textarea></td>
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
		minHeight: "500px",
		maxHeight: "500px"
	});
	
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 공지 등록 --</title>
<style>
.detail-container{
	width: 80%;
	margin: 50px auto;
	
}

.detail-block {
	border: 1px solid rgb(40,120,40);
}

.table-block {
	margin: auto;
	width: 100%;
	text-align: center;
}

td{
	padding: 10px !important;
	border: 1px solid rgb(40,120,40) !important;
}

.content-area {
	font-size: 30px;
	padding: 30px;
}

.other-notice {
	margin: 40px auto;
	width: 100%;
	border: 1px solid rgb(40,120,40);
}

.border-left{
	border-left:1px solid rgb(40,120,40);
	padding: 0px 10px; 
}

li{
	padding: 10px !important;
    border: 1px solid rgb(40,120,40) !important;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role="main">
		<div class="detail-container">
			<div class="detail-block">
				<table class="table-block">
					<tbody>
					<tr>
						<td>작성자</td>
						<td>${notice.writer }</td>
						<td>날짜</td>
						<td>${notice.regdate }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td colspan="3">${notice.title }</td>					
					</tr>
					</tbody>
				</table>
				
				<div class="content-area">
					${notice.content }
				</div>
				
			</div>
			
			<div class="other-notice">
				<ul>
					<li>이전 글 <span class="border-left">안녕하세요</span></li>
					<li>다음 글 <span class="border-left">안녕히가세요</span></li>
				</ul>
			</div>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />

</body>
</html>
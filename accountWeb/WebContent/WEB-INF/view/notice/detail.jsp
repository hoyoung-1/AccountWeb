<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 공지 등록 --</title>
<link rel="stylesheet" type="text/css" href="/resouces/css/notice/detail.css" />
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
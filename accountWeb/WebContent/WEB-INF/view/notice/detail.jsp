<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<li>이전 글 <span class="border-left"><a href="/notice/detail?noticeNo=${prevNotice.noticeNo }"> ${prevNotice.title }</a></span></li>
					<li>다음 글 <span class="border-left"><a href="/notice/detail?noticeNo=${nextNotice.noticeNo }"> ${nextNotice.title }</a></span></li>
				</ul>
			</div>
			<c:if test="${user.id eq 'kpw521' }">
			<form action="/notice/detail" method="post">
			<input type="hidden" name="noticeNo" value="${notice.noticeNo }" />
				<input type="submit" value="삭제" />
			</form>
			</c:if>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />

</body>
</html>
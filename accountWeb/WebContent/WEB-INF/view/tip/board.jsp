<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- tip 게시판 --</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role='main'>

		<div class="board-container">
			<div class="board-title">Tip 공유 게시글</div>

			<div class='board-event-block'>
				<p>공유하고 싶은 tip이 있다면 글을 올려주세요!
					 좋아요가 많은 게시글에는 상품을 드립니다!</p>
			</div>

			<div class="board-block">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>좋아요</th>
					</tr>
					<tbody>
						<!-- forEach문으로 데이터 가져오기  -->
					</tbody>
				</table>
			</div>

			<div class="board-page">
				<c:forEach var="i" begin="0" end="5">
					<ul><li>${i+1 }</li></ul>
				</c:forEach>
			</div>

		</div>

	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>
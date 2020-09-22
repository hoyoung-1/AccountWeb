<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- tip 게시판 --</title>
<style>
.board-container {
	margin: auto;
	width: 80%;
}

.board-block{
	margin: 30px 0px;
}

.table-block {
	margin: auto;
	width: 100%;
	text-align: center;
	border: 1px solid;
}

.board-page {
	display: flex;
    justify-content: space-around;
    width: 20%;
    margin: auto;
}

tr > th {
	background: rgb(40,220,40);
	padding: 10px 0px;
	border: 2px solid;
}

tr > td {
	border: 1px solid;
}
</style>
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
				<table class="table-block">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>좋아요</th>
					</tr>
					<tbody>
						<c:forEach var="tip" items="${tip }" begin="0" end="9">
						<tr>
							<td>${tip.tipId }</td>
							<td>${tip.title }</td>
							<td>${tip.writer }</td>
							<td>${tip.regdate }</td>
							<td>4</td>
						</tr>						
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="board-page">
				<a href="/tip/board?p=4">이전</a>
				<c:forEach var="i" begin="0" end="4">
					<ul><li>${i+1 }</li></ul>
				</c:forEach>
				<a href="">다음</a>
			</div>

		</div>

	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>
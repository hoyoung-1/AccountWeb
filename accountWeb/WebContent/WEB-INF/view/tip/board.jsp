<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- tip 게시판 --</title>
<link rel="stylesheet" href="/resouces/css/tip/board.css?after" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role='main'>

		<div class="board-container">
			<div class="board-title">Tip 공유 게시글</div>

			<div class='board-event-block'>
				<p>
					공유하고 싶은 tip이 있다면 글을 올려주세요! <br /> <span class="red">좋아요</span>가 많은
					게시글에는 상품을 드립니다!
				</p>
			</div>

			<div class="select-block">
				<form action="/tip/board" method="post">
					<select name="select">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
					</select> 
					<input type="text" name="answer" placeholder="검색" /> 
					<input type="submit" value="검색" />
				</form>
			</div>

			<div class="board-block">
				<table class="table-block">
					<tr>
						<th class="table-th-1">번호</th>
						<th>제목</th>
						<th class="table-th-2">작성자</th>
						<th class="table-th-3">작성일</th>
						<th class="table-th-4">좋아요</th>
					</tr>

					<c:set var="page" value="${empty param.p ? 1:param.p }" />
					<c:set var="startNum" value="${page-(page-1)%5 }" />
					<fmt:parseNumber var="lastNum" value="${cnt%10 == 0 ? cnt/10 : cnt/10+1}" integerOnly="true" />
					

					<tbody>
						<c:forEach var="tip" items="${tip }" begin="0" end="9">
							<tr class="tr-location" onclick="location.href='/tip/content?tipId=${tip.tipId}'">
								<td>${tip.tipId }</td>
								<td class="table-td-title">${tip.title }</td>
								<td>${tip.writer }</td>
								<td>${tip.regdate }</td>
								<td>4</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="page-info"> ${page } / ${lastNum }</div>
			
			<div class="board-page">
				<c:if test="${startNum >1 }">
				<a href="/tip/board?p=4">이전</a>
				</c:if>
				<c:forEach var="pageNum" begin="0" end="4">
					<ul>
						<c:if test="${lastNum >= startNum+pageNum }">
						<li><a class="${page eq (startNum+pageNum) ? 'green' :' ' }" href="/tip/board?p=${startNum+pageNum }">${startNum+pageNum }</a></li>
						</c:if>
					</ul>
				</c:forEach>
				<c:if test="${lastNum > 5 }">
				<a href="">다음</a>
				</c:if>
			</div>

		</div>

	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>
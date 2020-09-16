<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 공지사항 --</title>
<style>
.list-container {
	width: 80%;
	margin: auto;
}

.list-title {
	font-size: 50px;
	color: rgb(40, 120, 40);
	padding: 20px;
}

table {
	margin: 10px auto !important;
	width: 90%;
	border: 2px solid rgb(40, 120, 40) !important;
	text-align: center;
}

tr {
	cursor: pointer;
}

tr:hover {
	color: rgb(40, 120, 40);
}

th {
	padding: 10px !important;
	border: 2px solid !important;
	background: rgb(40, 220, 40) !important;
}

td {
	padding: 10px !important;
	border: 0.5px solid !important;
}

.page-info{
	position: absolute;
    right: 18%;
    width: 6%;
    border: 1px solid;
    padding: 5px;
    text-align: center;
}

.page-list {
	margin: 50px auto;
    width: 20%;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />

	<main role="main">
		<div class="list-container">
			<div class="list-title">공지사항</div>
			<div class="list-block">
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					<tbody>
						<c:forEach items="${list }" var="notice" begin="0" end="9">
							<tr
								onclick="location.href='/notice/detail?id=${notice.noticeNo}'">
								<td>${notice.noticeNo }</td>
								<td>${notice.title }</td>
								<td>${notice.writer }</td>
								<td>${notice.regdate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:set var="page" value="${empty param.p ? 1 : param.p }" />
				<!-- 현재 페이지 -->
				<c:set var="startNum" value="${page - (page-1)%5}" />
				<!-- 시작 페이지 번호  1,6,11,16-->
				<fmt:parseNumber var="lastNum" value="${count/5 }" integerOnly="true" />


				<div class="page-info">${startNum } / ${13 }</div>

				<div class="page-list">
						
						<div class="page-list-num">
						<a href=""> 이전</a>
					<c:forEach var="pageNum" begin="${startNum }" end="${lastNum }">
							
							<a href="/notice/list?p=${pageNum }">${pageNum }</a>
					</c:forEach>
						<a href="">다음</a>
						</div>

				</div>

			</div>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>
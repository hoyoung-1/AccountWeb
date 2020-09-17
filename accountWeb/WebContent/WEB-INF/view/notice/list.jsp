<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- 공지사항 --</title>
<link rel="stylesheet" type="text/css" href="/resouces/css/notice/list.css" />
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
								onclick="location.href='/notice/detail?noticeNo=${notice.noticeNo}'">
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
				<fmt:parseNumber var="lastNum"
					value="${count%10 == 0 ? count/10 : count/10+1}" integerOnly="true" />


				<div class="page-info">${empty param.p ? 1:param.p }/ ${lastNum }</div>

				<div class="page-list">

					<div class="page-list-num">
						<c:if test="${startNum <=1}">
						<a href="/notice/list?p=${param.p }" onclick="alert('이전 페이지가 없습니다.')"> 이전</a>
						</c:if>
						<c:if test="${startNum > 1 }">
						<a href="/notice/list?p=${startNum-1}"> 이전</a>
						</c:if>
						<c:forEach var="pageNum" begin="0" end="4">
							<c:if test="${lastNum >= startNum+pageNum }">
							<a class="${page == (startNum+pageNum)? 'green-bold' : '' }" href="/notice/list?p=${startNum+pageNum }">${startNum+pageNum  }</a>
							</c:if>
						</c:forEach>

						<c:if test="${startNum+5 <= lastNum }">
						<a href="/notice/list?p=${startNum+5 }">다음</a>
						</c:if>
						<c:if test="${startNum+5 > lastNum }">
						<a href="" onclick="alert('다음페이지가 존재하지 않습니다.')">다음</a>
						</c:if>
					</div>

				</div>

			</div>
		</div>
	</main>


	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>
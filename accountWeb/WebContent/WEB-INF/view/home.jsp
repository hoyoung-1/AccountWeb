<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>-- Account Web --</title>
<link rel="stylesheet" type="text/css" href="/resouces/css/home.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>	

	<main role="main">
		<div class="content-container">
			
			<div class="main-block">
				<div class="description-title">사용방법</div>
				<div class="description-block">
					<div class="description-img"></div>
					<div class="description-text">사용 방법입니다.</div>
				</div>
			</div>

			<div class="main-list-block">
				<div class="board-block">
				<div class="board-title">공지사항</div>
					<ul>
						<c:forEach var="l" begin="0" end="2">
							<li>[${l+1}] ${l+1 }번째</li>
						</c:forEach>
					</ul>
				</div>

				<div class="board-block">
				<div class="board-title">팁 정보</div>
					<ul>
						<c:forEach var="l" begin="0" end="2">
							<li>[${l+1}] ${l+1 }번째</li>
						</c:forEach>
					</ul>

				</div>
			</div>

		</div>
	</main>

<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>

</body>
</html>
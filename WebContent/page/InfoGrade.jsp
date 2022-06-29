<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트페이지</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/infoGrade.css">
</head>
<body>
    <div class="container">
		<jsp:include page="/form/header.jsp" />
		<jsp:include page="/form/nav.jsp" />
        <section>
			<!-- 메인 컨텐츠 입력 -->
			<h2>후보자 등수</h2>
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.m_No}</td>
						<td>${list.m_Name}</td>
						<td>${list.vNo}</td>
					</tr>
				</c:forEach>
			</table>
        </section>
		<jsp:include page="/form/footer.jsp" />
    </div>
</body>
</html>
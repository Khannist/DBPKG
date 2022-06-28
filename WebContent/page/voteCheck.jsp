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
<link rel="stylesheet" href="css/voteCheck.css">
</head>
<body>
    <div class="container">
		<jsp:include page="/form/header.jsp" />
		<jsp:include page="/form/nav.jsp" />
        <section>
			<!-- 메인 컨텐츠 입력 -->
			<table border="1" align="center">
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<c:forEach items="${List}" var="list">
					<tr>
						<td>${list.v_Name}</td>
						<td>${list.v_Jumin}</td>
						<td>${list.age}</td>
						<td>${list.gender}</td>
						<td>${list.m_No}</td>
						<td>${list.v_Time}</td>
						<td>${list.v_Confirm}</td>
					</tr>
				</c:forEach>
			</table>
        </section>
		<jsp:include page="/form/footer.jsp" />
    </div>
</body>
</html>
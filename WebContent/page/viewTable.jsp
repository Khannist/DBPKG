<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보 조회</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
		<jsp:include page="/form/header.jsp" />
		<jsp:include page="/form/nav.jsp" />
        <section>
			<h1>후보 조회</h1>
			
			<table id = "" class = "" border = "1">
				<tr>
					<th>후보 번호</th>
					<th>성명</th>
					<th>소속 정당</th>
					<th>학력</th>
					<th>주민 번호</th>
					<th>지역구</th>
					<th>대표 전화</th>
				</tr>
				<c:forEach var="member" items="${memberList}" varStatus="status">
				<tr>
					<td>${member.m_No}</td>
					<td>${member.m_Name}</td>
					<td>${partyList[status.index].p_Name}</td>
					<td>${member.p_School}</td>
					<td>${member.m_Jumin}</td>
					<td>${member.m_City}</td>
					<td>${partyList[status.index].p_Tel1} - ${partyList[status.index].p_Tel2} - ${partyList[status.index].p_Tel3}</td>
				</tr>
				</c:forEach>
			</table>
			
        </section>
		<jsp:include page="/form/footer.jsp" />
    </div>
</body>
</html>
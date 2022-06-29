<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
    <div class="container">
		<jsp:include page="../form/header.jsp" />
		<jsp:include page="../form/nav.jsp" />
        <section>
			<!-- 메인 컨텐츠 입력 -->
			<h1>투표하기</h1>
			<form action="DP" method="post" name="vote_form">
				<input type="hidden" name="command" value="vote_write">
				<table border="1">
					<tr>
						<th>주민번호</th>
						<td>
							<input type="text" id="v_Jumin"> 예 : 8906153154726
						</td>
					</tr>
					<tr>
						<th>성명</th>
						<td>
							<input type="text" id="v_Name">
						</td>
					</tr>
					<tr>
						<th>투표번호</th>
						<td>
						<!-- 후보자 리스트 가져오기 -->
						<select name="m_No">
							<c:forEach var="m" items="${member_List }">
								<option value="${m.m_No }">${m.m_Name } </option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<th>투표시간</th>
						<td>
							<input type="text" id="v_Time">
						</td>
					</tr>
					<tr>
						<th>투표장소</th>
						<td>
							<input type="text" id="v_Area">
						</td>
					</tr>
					<tr>
						<th>유권자 확인</th>
						<td>
							<input type="radio" class="v_Confirm" name="v_Confirm" value="Y">확인
							<input type="radio" class="v_Confirm" name="v_Confirm" value="N" checked>미확인
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button"onclick="check();">투표하기</button>
							<input type="reset" value="다시하기">
						</td>
					</tr>
				</table>
			</form>
        </section>
		<jsp:include page="../form/footer.jsp" />
    </div>
    <script type="text/javascript">
    	function check(){
    		// 주민번호 V_Jumin, 성명 V_Name, 투표번호 M_No, 투표시간 V_Time, 투표장소 V_Area, 유권자 확인 V_Confirm 
			var v_Jumin = document.getElementById("v_Jumin");
    		var v_Name = document.getElementById("v_Name");
    		// 후보자 리스트 받아야함
    		//var M_No = document.getElementById("M_No");
    		var v_Time = document.getElementById("v_Time");
    		var v_Area = document.getElementById("v_Area");
    		
    		if(!v_Jumin.value){
    			alert("주민번호가 입력되지 않았습니다!");
    			v_Jumin.focus();
    			return false;
    		}
    		if(!v_Name.value){
    			alert("성명이 입력되지 않았습니다!")
    			v_Name.focus();
    			return false;
    		}
    		/* if(!m_No.value){
    			alert("후보번호가 선택되지 않았습니다!");
    			m_No.focus();
    			return false;
    		} */
    		if(!v_Time.value){
    			alert("투표시간이 입력되지 않았습니다!");
    			v_Time.focus();
    			return false;
    		}
    		if(!v_Area.value){
    			alert("투표장소가 입력되지 않았습니다!");
    			v_Area.focus();
    			return false;
    		}
    		/* if(!v_Confirm.value){
    			alert("유권자 확인이 선택되지 않았습니다!");
    			v_Confirm.focus();
    			return false;
    		} */
    		
    		//입력 값 전송
    		document.vote_form.submit(); 
    	}
    </script>
</body>
</html>
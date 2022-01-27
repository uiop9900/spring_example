<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 (2)</title>
</head>
<body>
	<h1>1.조건문(c:choose, c:when, c:otherwise) </h1>
	<c:set var="weight" value="62" />
	
	<c:choose> <%--모든 조건이 when으로 거르고 else는 otherwise로 한다. 이 조건문은 choose태그로 감싼다 --%>
		<c:when test="${weight < 60}"> <%--이 조건 참일때 안의 태그 들어가 수행하고 나간다. --%>
			치킨먹자!!!<br>
		</c:when>	
			
		<%--60 ~ 70미만, 이미 위에서 걸러져서 여기 왔기때문에 굳이 60조건을 추가하지않는다. --%>
		<c:when test="${weight < 70}">
			샐러드 먹자!!!<br>
		</c:when>

		<%-- 70이상(else) --%>
		<c:otherwise>
			굶자<br>
		</c:otherwise>		
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1>
	<c:forEach begin="0" end="5" step="1" var="var1"><%--끝값도 포함 -> 6번 반복한다. --%>
		${var1}<br>
	</c:forEach>
	
	<%-- 16 ~ 20 : 5번 --%>
	<c:forEach begin="16" end="20" step="1" var="var2" varStatus="status"> <%--관례적으로 status로 만든다. 애는 객체임 --%>
		${var2} current:${status.current} <%--현재 value의 값 --%> 
		first: ${status.first} <%--첫번째 반복일때만 true --%>
		last: ${status.last}  <%--마지막 반복일때만 true --%>
		count: ${status.count} <%--몇 번 반복하는지 count한다. 1부터 시작 --%>
		index: ${status.index} <%--list같은걸 반복문 돌릴때 좋음, 지금은 간단반복이라 current랑 값이 똑같음 --%>
		<br>
	</c:forEach>
	
	<%--서버에서 가져온 List<String> 출력 --%> <%--뿌리기위한 로직만 가능하고 헤비하고 중요한 코드들은 여기에 적지않는다. 서버는 로직, 뷰는 뿌리는 화면, 롤을 제대로 나눈다. --%>
	<c:forEach var="fruit" items="${fruits}" varStatus="status"> 	<%--향상된 for문, 속성 순서는 상관없음, var="하나씩 꺼낼때 나오는 것을 담을 변수 --%>
		${fruit}
		count: ${status.count} <%--1부터 시작, 반복 횟수 : 5 --%>
		index: ${status.index} <%--0부터 시작,  list에서 값꺼낼때 좋음 // 4 --%>
		<br>
	</c:forEach>
	
	<%-- 서버에서 가져온 List<Map<String, Object>> 출력 --%>
	<c:forEach var="idol" items="${users}" varStatus="status"> <%--map을 하나씩 idol로 꺼낸다. var에 저장된대로 아래서 EL쓰는것임  --%>
		<h3>${status.count}번째 사람 정보</h3>
		이름: ${idol.name}<br>
		나이: ${idol.age}<br>
		취미: ${idol.hobby}
	</c:forEach>
	
	<%--사람정보 테이블 구성 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th><%--번호가 db번호인지 순번인지 확인! --%>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<%--반복구간에서 반복문 열기 --%>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.hobby}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
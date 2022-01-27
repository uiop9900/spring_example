<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPL fmt 라이브러리</title>
</head>
<body>
	<c:set var="number">12345678</c:set>
	<h3>숫자 출력</h3>
	
	<fmt:formatNumber value="${number}" /> <%--12,345,678 --%>
	
	<h3>Type</h3>
	숫자: <fmt:formatNumber value="${number}" type="number" /><br>
	숫자 3자리마다 쉼표 제거: <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br> <%--true: grouping한다, false: 사용하지않는다. --%> 
	<%--1이 100% --%>
	100%: <fmt:formatNumber value="1" type="percent" /><br>
	40%: <fmt:formatNumber value="0.4" type="percent" /> <br>
	
	통화(원): <fmt:formatNumber value="${number}" type="currency" /><br>
	통화(달러): <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/><br>
	
	<h3>var로 변수에 저장</h3> <%--var속성을 추가하면 거기에 담는다. --%>
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="$" var="dollar" /> <%-- dollar변수에 저장만하고 출력하지 않음 --%>
	달러 값을 EL로 출력: ${dollar}
	
	<h3>pattern</h3>
	3.14: <fmt:formatNumber value="3.14"/><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000" /> <br> <%--숫자없어도 0으로 나타낸다 --%>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /> <br> <%--있는 숫자까지만 나타낸다 --%>
	3.14(#.####): <fmt:formatNumber value="3.141592" pattern="#.####"/><br> <%--넘치면 버린다. --%>	


	<hr>
	
	<h3>Date객체를 String 형태로 출력 => fmt:formatDate</h3>
	${today}<br> <%--Thu Jan 27 17:33:35 KST 2022 - date객체 --%>
	<fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="pattern1" /> <%--var변수에 담으면 따로 출력을 해줘야지만 출력된다. --%>
	pattern1: ${pattern1}<br>
	<fmt:formatDate value="${today}" pattern="yyyy/MM/dd a HH:mm:ss" />
	
	<h3>String을 Date객체로 변환 => fmt:parseDate </h3>
	<fmt:parseDate value="${pattern1}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" var="date2"/> <%--패턴이 일치해야지 그 String을 Date로 바꾼다.  --%>
	Date객체: ${date2}	
		
</body>
</html>
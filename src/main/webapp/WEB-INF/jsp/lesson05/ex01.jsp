<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title><!-- 태그로 java문법 쓰기 -->
</head>
<body>
	<h2>1. 변수 정의하기 (c:set)</h2>
	
	<c:set var="number1" value="100"/> <!-- 반드시 닫는게 있어야하고 number1 = 100 한거임 -->
	<c:set var="number2">250</c:set>
	
	number1: ${number1}<br>
	number2: ${number2}<br>
	number1 + number2 : ${number1 + number2} <!-- 이 괄호안에서 더해야한다.(숫자끼리만 연산가능) 밖으로 나가면 String -->
		
	<h2>2. 변수 출력하기 (c:out)</h2>
	number1: <c:out value="${number1}"/><br> <!-- 여기서 value는 어떤 변수를 출력할건인가? 100넣으면 그냥 100출력 -->
	<c:out value="Hello World!"/><br>
	
	<%-- 글자그대로 출력된다. --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>"/> 
	<%-- 글자그대로 출력된다. --%>
	<c:out value="<script>console.log('콘솔 로그 찍기');</script>" escapeXml="true" /><br> <!-- 동작실행 -->
	<%-- 수행된다. --%>
	<c:out value="<script>console.log('콘솔 로그 찍기');</script>" escapeXml="false" /><br> <!-- 동작실행 -->
	
	<h2>3. 조건문 (c:if) </h2>
	<c:if test="${number1 > 50}"> <%--조건이 참이면 출력된다 --%> 
		number1은 50보다 크다<br>
	</c:if>
	
	<%--같다 --%>
	<c:if test="${number1 == 100}"> <%--등호는 불안할수있으니 eq를 통해서 비교도 가능하다. 검증 잘하기 --%> 
		number1은 100이다.<br>	
	</c:if>
	
	<c:if test="${number1 eq 100}">
		number1은 100이다.<br>
	</c:if>
	
	<%--다르다 --%>
	<c:if test="${number != 200 }">
		number1은 200이 아니다.<br>
	</c:if>
	
	<c:if test="${number ne 200 }"> <%-- not equal --%>
		number1은 200이 아니다.<br>
	</c:if>
	
	<c:if test="${not empty number1}"> <%--비어있지않다. --%>
		number1은 비어있지 않다.<br>
	</c:if>
	
	<c:if test="${!empty number1}"> <%--느낌표 부정가능. --%>
		number1은 비어있지 않다.<br>
	</c:if>
	
</body>
</html>
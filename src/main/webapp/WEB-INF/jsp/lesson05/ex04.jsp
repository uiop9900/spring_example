<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain." />
	
	<h1>1. 길이 구하기</h1> <%--el태그 안에서 사용한다. --%>
	${fn:length(str1)} <br> <%--17 --%>
	
	<h1>2. 특정문자열 있는지 확인</h1>
	No가 있는가? ${fn:contains(str1, "No")} <br> <%--어떤 문장에 어떤 단어가 있는가? 파라가 2개 --%>		
	no가 있는가? ${fn:contains(str1, "no")} <br> <%--대소문자 구분한다. --%>
	
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}"> <%--true 혹은 false를 리턴하며 ture값이어야 if문 안으로 들어온다. --%>
		문장에 no라는 문자열이 존재합니다.(대소문자 구별하지 않음)
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인</h1>
	No로 시작하는가? ${fn:startsWith(str1, "No")} <br> <%--true, 대소문자 구분한다. --%>
	
	<h1>4. 특정 문자열로 끝나는지 확인</h1>
	n으로 끝나는가? ${fn:endsWith(str1, "n")} <br> <%--false --%>
	.으로 끝나는가? ${fn:endsWith(str1, ".")} <br><%--false - 자바에서의 .은 정규식과 연관되어있어서 온점은 따로 인식하기 어렵다. 온점 조심하기 --%>
	gain.으로 끝나는가? ${fn:endsWith(str1, "gain.")} <%--true, 온점 단독사용은 지양 --%>
	
	<h1>5. 문자열 치환</h1>
	<c:set var="str2">I love chicken.</c:set>
	${str2}<br>
	${fn:replace(str2, 'chicken', 'bread')} <%--파라3개: 문자열, 지금문자, 바꾸고자하는 문자 --%>
	
	<h1>6. 구분자로 잘라서 배열만들기</h1>
	${fn:split(str1, '.')[0]} <br> <%--자르면 배열이 되기때문에 [index] 넣어서 확인해야한다. --%>
	${fn:split(str1, '.')[1]} <br>
	
	<h1>7. 시작인덱스부터 끝인덱스까지 자르기</h1>
	<%--love 추출--%>
	${fn:substring(str2, 2, 6)} <%--파라3개: 문자열, 시작인덱스, 끝인덱스 --%>
	
	<h1>8. 모두 소문자로 변경하기</h1>
	${fn:toLowerCase(str2)}
	
	<h1>9. 모두 대문자로 변경하기</h1>
	${fn:toUpperCase(str2)}<br>
	
	<h1>10. 앞 뒤 여백 제거 </h1>
	<c:set var="str3" value="          hello               " />
	<pre>${str3}</pre>
	${fn:trim(str3)}
	
</body>
</html>
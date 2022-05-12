<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<!-- Controller1에 요청하기 -->
	<a href="${contextPath}/detail1?name=민경태&age=45">정보전달1</a><br>
	<a href="${contextPath}/detail2?name=민경태&age=45">정보전달2</a><br>
	<a href="${contextPath}/detail3?name=민경태&age=45">정보전달3</a><br>
	










</body>
</html>
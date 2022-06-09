<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<h3>다시 찾아 주셔서 감사합니다.</h3>
	
	<div>
		회원님의 가입 정보를 안내해 드립니다.
	</div>
	
	<form>
	
		가입 아이디<br>
		${member.id}<br><br>
		
		가입자명<br>
		${member.name}<br><br>
		
		가입 당시 이메일<br>
		${member.email.substring(0,3)}***${member.email.substring(member.email.indexOf('@'))}<br><br>
		
		탈퇴일<br>
		${member.signOut}<br><br>
	
	</form>
	
</body>
</html>
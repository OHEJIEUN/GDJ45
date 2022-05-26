<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<script>

	if('${insRes}' > '0') {
		alert('등록 성공');
		location.href='${contextPath}/board/list';
	} else {
		alert('등록 실패');
		history.back();
	}

</script>
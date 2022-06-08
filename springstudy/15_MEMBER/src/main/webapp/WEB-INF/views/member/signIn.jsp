<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>

	/* 페이지 로드 이벤트 */
	$(function(){
		fnIdCheck();	
	})
	
	/* 함수 */
	
	// 1. 아이디 정규식 & 중복체크
	let idPass = false;
	function fnIdCheck(){
		$('#id').on('keyup', function(){
			// 정규식 체크하기
			let regId = /^[a-z]{1,32}$/;  // 소문자 1~32자 사이(실제 서비스는 바꿔야 함)
			if(regId.test($('#id').val())==false){
				$('#idMsg').text('아이디는 어쩌구 저쩌구 입니다.');
				idPass = false;
				return;
			}
			// 아이디 중복 체크
			$.ajax({
				url: '${contextPath}/member/idCheck',
				type: 'get',
				data: 'id=' + $('#id').val(),
				dataType: 'json',
				success: function(obj){
					
				},
				error: function(jqXHR){
					$('#idMsg').text(jqXHR.responseText);
					idPass = false;
				}
			})
		})
	}


</script>
</head>
<body>
	
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<h3>회원 가입</h3>
	
	<form id="f" action="${contextPath}/member/signIn" method="post">
	
		<input type="hidden" name="agreements" value="${agreements}">
		
		<label for="id">
			아이디<br>
			<input type="text" name="id" id="id"><br>
			<span id="idMsg"></span>
		</label><br><br>
	
	</form>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
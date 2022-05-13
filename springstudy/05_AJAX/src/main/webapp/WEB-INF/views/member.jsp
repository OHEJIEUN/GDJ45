<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.6.0.js"></script>
<script>
	
	// 페이지 로드 이벤트
	$(document).ready(function(){
		$('#btn1').on('click', function(){ fnAjax1(); })  // btn1을 클릭하면 fnAjax1() 함수를 실행하시오.
		$('#btn2').on('click', function(){ fnAjax2(); })
		$('#btn3').on('click', fnAjax3)
	})
	
	// 함수
	
	// 요청 데이터 : 파라미터
	// 응답 데이터 : 텍스트
	function fnAjax1(){
		
		$('#result').empty();
		
		$.ajax({
		
			/* 요청에 관한 프로퍼티 : url, type, data, contentType */
			url: '${contextPath}/member/detail1',                    // 요청 URL(매핑), MemberController에서 매핑을 찾자.
			type: 'get',                                             // 요청 메소드(get, post 등)
			data: 'id=' + $('#id').val() + "&pw=" + $('#pw').val(),  // MemberController로 보내는 파라미터 id와 pw
			
			/* 응답 데이터에 관한 프로퍼티 : dataType, success, error */
			dataType: 'text',        // 응답 데이터 타입 text
			success: function(res){  // 응답 데이터는 res에 전달됨
				$('#result').text(res);
			},
			error: function(jqXHR){
				$('#result').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
			
		})
		
	}  // fnAjax1
	
	
	// 요청 데이터 : 파라미터
	// 응답 데이터 : JSON
	// {"id": "admin", "pw" "123456"}
	function fnAjax2(){
		
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			url: '${contextPath}/member/detail2',
			type: 'get',
			data: $('#f').serialize(), // <input name="id">에 입력된 값은 파라미터 id로 전달
			                           // <input name="pw">에 입력된 값은 파라미터 pw로 전달
			/* 응답 */
			dataType: 'json',          // 응답 데이터 타입 json
			success: function(obj){    // 응답 데이터는 obj에 전달
				
				// obj는 {"id": 아이디, "pw": 비밀번호} 모습이다.
				
				$('<ul>')                        // <ul>
				.append($('<li>').text(obj.id))  //   <li>obj.id</li>
				.append($('<li>').text(obj.pw))  //   <li>obj.pw</li>
				.appendTo($('#result'));         // </ul>
				
			},
			error: function(jqXHR){
				$('#result').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
			
		})
		
	}  // fnAjax2
	
	
	// 요청 데이터 : 파라미터
	// 응답 데이터 : JSON
	// {"id": "admin", "pw" "123456"}
	function fnAjax3(){
		
		$('#result').empty();
		
		$.ajax({
			/* 요청 */
			url: '${contextPath}/member/detail3',
			type: 'get',
			data: $('#f').serialize(),
			/* 응답 */
			dataType: 'json',
			success: function(obj){

				// obj는 {"id": 아이디, "pw": 비밀번호} 모습이다.
				
				$('<ul>')                        // <ul>
				.append($('<li>').text(obj.id))  //   <li>obj.id</li>
				.append($('<li>').text(obj.pw))  //   <li>obj.pw</li>
				.appendTo($('#result'));         // </ul>
				
			},
			error: function(jqXHR){
				$('#result').text(jqXHR.status + ' : ' + jqXHR.responseText);
			}
			
		})
		
	}  // fnAjax3
	
	
	
</script>
</head>
<body>

	<form id="f">
		<input type="text" name="id" id="id" placeholder="ID"><br>
		<input type="text" name="pw" id="pw" placeholder="Password"><br><br>
		<input type="button" value="전송1" id="btn1">
		<input type="button" value="전송2" id="btn2">
		<input type="button" value="전송3" id="btn3">
	</form>
	
	<hr>
	
	<div id="result"></div>

</body>
</html>
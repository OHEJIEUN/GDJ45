<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		fnList();
		fnDetail();
		fnAdd();
		fnReList();
	})
	
	function fnList(){
		// 화면이 열리면 곧바로 실행
		$.ajax({
			url: 'list.json',
			type:'get',
			dataType: 'json',
			success: function(responseText){
				$('#staffList').empty();  // 회원 목록의 초기화
				$.each(responseText.staff, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#staffList').append(tr);
				})
			}
		})
	}
	
	function fnDetail(){
		$('#detailBtn').on('click', function(){
			var n = document.getElementById('stfNor');
			if(n.value.length != 5){
				alert('사원번호는 5자리 숫자입니다.');
				ev.preventDefault();
			}
			
			var sno = $('#stfNor').val();
			$.ajax({
				url: 'detail.json',
				data: 'sno=' + sno,
				type: 'get',
				dataType: 'json',
				success: function(responseText){  // responseText : {}
					$('#staffList').empty();
					var tr = '<tr>';
					tr += '<td>' + responseText.sno + '</td>';
					tr += '<td>' + responseText.name + '</td>';
					tr += '<td>' + responseText.dept + '</td>';
					tr += '<td>' + responseText.salary + '</td>';
					tr += '</tr>';
					$('#staffList').append(tr);
				}
			})
		})
	}
	
	function fnReList(){
		$('#listBtn').on('click', function(){
			fnList();
		})
		
	}
	
	function fnAdd(){
		$('#stfAdd').on('click',function(){
			var n = document.getElementById('stfNo');
			var d = document.getElementById('stfDept');		
			if((d.value.length < 3) && (d.value.length > 5)){
				alert('부서는 3~5자리 한글입니다.');
				ev.preventDefault();
			} else if(n.value.length != 5){
				alert('사원번호는 5자리 숫자입니다.');
				ev.preventDefault();
			}
			
			
			
			$.ajax({
				url:'add.json',
				type:'post',
				data: $('#formStfAdd').serialize(),
				success: function(responseText){
					if(responseText.res == 1){
						alert('신규 회원이 등록되었습니다.');
						fnList();
					}
				},
				error: function(jqXHR){
					alert(jqXHR.status);
					alert(jqXHR.responseText);
				}
			})
		})
		
	}

</script>
</head>
<body>

	
	<h1>사원등록</h1>
	<form id="formStfAdd">
		<input type="text" name="stfNo" id="stfNo" placeholder="사원번호">
		<input type="text" name="stfName" id="stfName" placeholder="사원명">
		<input type="text" name="stfDept" id="stfDept" placeholder="부서명">
		<input type="button" id="stfAdd" value="등록">
	</form>
	
	<hr><br>
	
	<h1>사원조회</h1>
	<form id="formStfList">
	<input type="text" name="stfNor" id="stfNor" placeholder="사원번호조회">
	<input type="button" id="detailBtn" value="조회">
	<input type="button" id="listBtn" value="전체">
	</form>
	
	
	<hr><br>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>부서명</td>
					<td>연봉</td>
				</tr>
			</thead>
			<tbody id="staffList"></tbody>
		</table>
	</div>

</body>
</html>
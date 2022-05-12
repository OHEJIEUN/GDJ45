<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	fnModify();
	fnRemove();
	fnInit();
})

function fnList(){
		// 화면이 열리면 곧바로 실행
		$.ajax({
			url: '/StaffProject/list.json',
			dataType: 'json',
			success: function(responseText){  // responseText : {"count":7, "members":[]}
				$('#staffCount').text(responseText.count)
				var memberList = $('#staffList');
				$.each(responseText.staffs, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					staffList.append(tr);
				})
			}
		})
		
	}



</script>
</head>
<body>
<h3>사원등록</h3>
	<form id="formStaff">
	<div>
		<input type="text" name="No" placeholder="사원번호">
		<input type="text" name="name" placeholder="사원명">
		<input type="text" name="dept" placeholder="부서명">
		<button>등록</button>
	</div>
	</form>
	<hr>
	<h3>사원조회</h3>
	<div>
		<input type="text" name="nameNo" placeholder="사원번호입력">
		<input type="button" value="조회" id="btn	abc">
		<input type="button" value="전체" id="btndef">
	</div>
	<hr>
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
			<tbody id="StaffList">
			</tbody>
		</table>
	</div>
</body>
</html>
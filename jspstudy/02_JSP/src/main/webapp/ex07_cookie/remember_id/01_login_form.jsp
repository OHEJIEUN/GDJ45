<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="02_remember_id.jsp" method="post">
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="pw" placeholder="비밀번호">
		</div>
		<div>
			<button>로그인</button>
		</div>
		<div>
			<label>
				<input type="checkbox" name="checkRememberId">
				아이디 기억
			</label>
		</div>
	</form>

</body>
</html>
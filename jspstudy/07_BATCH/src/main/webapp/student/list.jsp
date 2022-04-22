<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/student.css">
</head>
<body>

	<div class="wrap">
		<h1 class="title">학생전체목록</h1>
		<div class="btn_area">
			<input type="button" value="학생등록하기" class="btn_insert" onclick="location.href='/BATCH/insertPage.do'">
		</div>
		<table>
			<caption>전체 학생 수 : ${totalCount}명</caption>
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>평균</td>
					<td>학점</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount eq 0}">
					<tr>
						<td colspan="8">등록된 학생이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${totalCount ne 0}">
					<c:forEach items="${list}" var="student">
						<tr>
							<td>${student.stuNo}</td>
							<td>${student.name}</td>
							<td>${student.kor}</td>
							<td>${student.eng}</td>
							<td>${student.mat}</td>
							<td><fmt:formatNumber value="${student.avg}" pattern="0.00" /></td>
							<td>${student.grade}</td>
							<td>
								<input type="button" value="수정" class="btn_update">
								<input type="button" value="삭제" class="btn_delete">
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">전체 평균</td>
					<td><fmt:formatNumber value="${totalAverage}" pattern="0.00" /></td>
					<td></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- HTML 주석 : 소스보기에서 보인다. -->
	<%-- JSP 주석 : 소스보기에서 안 보인다. --%>

	<%--
	
		1. JSP
			1) Java Server Page
			2) HTML 내부에 Java 코드를 넣을 수 있다.
			3) Servlet 기반이다.
				(1) JSP를 실행하면 Servlet이 생성된다.
				(2) abc.jsp -> abc_jsp.java
				
		2. JSP 스크립트 요소
			1) 지시어(directive)
				(1) <%@ page %>    : JSP 페이지 정보
				(2) <%@ include %> : 다른 JSP 페이지 포함
				(3) <%@ taglib %>  : 확장 태그 사용
			2) 선언부(declaration)
				(1) <%! int a = 10; %> : 전역 변수 선언
				(2) <%! void a(){} %>  : 메소드 정의
			3) 표현식(expression)
			    (1) <%= a %>    : 변수 a의 값
			    (2) <%= a+1 %>  : 연산 결과 값
			    (3) <%= a() %>  : 메소드 호출 결과 값(반환값)
			4) 스크립트릿(scriptlet)
			    <% 일반 Java 코드 %>
	
	--%>




</body>
</html>
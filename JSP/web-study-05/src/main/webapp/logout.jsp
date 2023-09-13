<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<% 	// 쿠키 전부 삭제해버리기
	Cookie[] ck2 = request.getCookies();
	for(Cookie c : ck2){
		c.setMaxAge(0);	// 쿠키의 유효기간을 만료시킴
		response.addCookie(c);
	}
%>

<script>
	alert("로그아웃되었습니다.");
	location.href="loginForm.jsp";
	</script>
</body>
</html>
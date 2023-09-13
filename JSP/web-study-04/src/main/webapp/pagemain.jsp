<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
int option = Integer.parseInt(request.getParameter("option"));

switch(option){
case 1: response.sendRedirect("https://naver.com");
		break;
case 2:
case 3:
case 4:
}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta char1set="UTF-8">
<title>JSP</title>
</head>
<body>
<form method="post" action="testLogin.jsp">
	<label for="userid"> 아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	
	<label for="userpwd"> 암 &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd"><br>
	
	<input type="submit" value="로그인">	
</form>
</body>
</html>
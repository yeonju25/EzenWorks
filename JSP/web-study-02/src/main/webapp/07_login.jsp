<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
</head>
<body>

<!-- 기은님's tip : method가 get으로 설정되어 있으면
	doGet 안에서 doPost함수를 이용해도 무조건 get방식으로 처리한다. -->
<form method="get" action="LoginServlet">

	<!-- label을 하면 저 글씨 아이디를 클릭하면 userid로 설정된 빈칸으로 커서가 이동하는 기능을 수행 -->
	<label for="userid"> 아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	
	<label for="userpwd"> 암 &nbsp; 호 : </label>
	<input type="password" name="pwd" id="userpwd"><br>
	ㄴ
	<input type="submit" value="로그인">
</form>
</body>
</html>
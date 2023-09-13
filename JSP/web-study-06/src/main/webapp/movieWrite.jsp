<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="movie" class="com.mission.javabeans.MovieBean"/>
<jsp:setProperty name="movie" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 처리 페이지</title>
</head>
<body>
<h1>입력 완료된 정보</h1>
<table>
	<tr>
		<td> 이름 </td>
		<td><jsp:getProperty property="title" name="movie"/></td>
	</tr>
	<tr>
		<td> 아이디 </td>
		<td><jsp:getProperty property="price" name="movie"/></td>
	</tr>	
	<tr>
		<td> 감독 </td>
		<td><jsp:getProperty property="director" name="movie"/></td>
	</tr>
	<tr>
		<td> 출연배우 </td>
		<td><jsp:getProperty property="actor" name="movie"/></td>
	</tr>
	<tr>
		<td> 시놉시스 </td>
		<td><jsp:getProperty property="synobsis" name="movie"/></td>
	</tr>
	<tr>
		<td> 장르 </td>
		<td><jsp:getProperty property="genre" name="movie"/></td>
	</tr>
</table>

</body>
</html>
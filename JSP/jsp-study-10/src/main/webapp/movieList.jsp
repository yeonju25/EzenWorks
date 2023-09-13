<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
<link rel="stylesheet" type="text/css" href="css/movie.css">
</head>
<body>
<div class="wrap" align="center">
	<h1>리스트</h1>
	<table>
		<tr style="border: solid white; text-align: right">
			<td colspan="6">
				<a href="movieWrite.do">정보등록</a>
			</td>
		</tr>
		<tr>
			<th>제목</th><th>감독</th><th>배우</th><th>가격</th><th>수정</th><th>삭제</th>
		</tr>
		<tr>
			<c:forEach var="movie" items="${movieList}">
			<tr class="recode">
				<td>${movie.title}</td>
				<td>${movie.director}</td>
				<td>${movie.actor}</td>
				<td>${movie.price}원</td>
				<td>	
					<a href="movieUpdate.do?code=${movie.code}">정보 수정</a>
				</td>
				<td>
					<a href="movieDelete.do?code=${movie.code}">정보 삭제</a>
				</td>
			</tr>
		</c:forEach>
		</tr>
	</table>


</div>
</body>
</html>
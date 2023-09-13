<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
<link rel="stylesheet" type="text/css" href="css/movie.css">
</head>
<body>
<div class="wrap" align="center">
	<h1>정보 삭제</h1>
	<form method="post" enctype="multipart/form-data" name="frm">
		<input type="hidden" name="code" value="${movie.code}"> 
         <input type="hidden" name="nonmakeImg" value="${movie.poster}">
		<table>
			<tr>
				<td rowspan="6" align="center">
					<img src="images/${movie.poster}">
				</td>
				<th>제 목</th>
				<td>${movie.title}</td>
			</tr>
			<tr>
				<th>가 격</th>
				<td>${movie.price}</td>
			</tr>
			<tr>
				<th>감 독</th>
				<td>${movie.director}</td>
			</tr>
			<tr>
				<th>배 우</th>
				<td>${movie.actor}</td>
			</tr>
			<tr>
				<th>시놉시스</th>
				<td>${movie.synopsis}</td>
			</tr>
			<tr>
				<th>사 진</th>
				<td>${movie.poster}</td>
			</tr>
		</table>
			<br>
				<input type="submit" value="삭제">
				<input type="button" value="목록" onclick="location.href='movieList.do'">
	</form>
</div>
</body>
</html>
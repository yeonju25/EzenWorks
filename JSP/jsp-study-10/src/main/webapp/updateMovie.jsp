<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 수정</title>
<link rel="stylesheet" type="text/css" href="css/movie.css">
</head>
<body>
<div class="wrap" align="center">
	<h1>정보 수정</h1>
	<form method="post" enctype="multipart/form-data" name="frm">
		<input type="hidden" name="code" value="${movie.code}"> 
         <input type="hidden" name="nonmakeImg" value="${movie.poster}">
		<table>
			<tr>
				<td rowspan="6" align="center">
               		<c:choose> 
	                     <c:when test="${empty movie.poster}">
	                        <img src="images/noimage.jpg">
	                     </c:when>
	                     <c:otherwise>
	                        <img src="images/${movie.poster}">
	                     </c:otherwise>
                  	</c:choose>
               </td>
				<th>제 목</th>
				<td><input type="text" name="title" size="50" value="${movie.title}"></td>
			</tr>
			<tr>
				<th>가 격</th>
				<td><input type="text" name="price" size="50" value="${movie.price}"></td>
			</tr>
			<tr>
				<th>감 독</th>
				<td><input type="text" name="director" size="50" value="${movie.director}"></td>
			</tr>
			<tr>
				<th>배 우</th>
				<td><input type="text" name="actor" size="50" value="${movie.actor}"></td>
			</tr>
			<tr>
				<th>시놉시스</th>
				<td><textarea name="synopsis" cols="70" rows="20">${movie.synopsis}</textarea></td>
			</tr>
			<tr>
				<th>사 진</th>
				<td><input type="file" name="poster"></td>
			</tr>
		</table>
			<br>
				<input type="submit" value="수정">
				<input type="button" value="목록" onclick="location.href='movieList.do'">
	</form>
</div>
</body>
</html>
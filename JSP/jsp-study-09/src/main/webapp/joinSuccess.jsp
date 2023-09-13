<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" width="550">
		<tr>
			<td colspan="2">
				<h3>사원정보</h3>
				<div style="color:red">${message}</div>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${member.pass}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.name}</td> 
			<!-- MyPageServlet에서 member에 넣어놨기 때문에 member.name써도 되고 loginUser.name 써도 됨 -->
		</tr>
		<tr>
			<td>권한</td>
			<td>
				<c:choose>
					<c:when test='${member.lev=="A"}'>운영자</c:when>
					<c:otherwise>일반회원</c:otherwise>
				</c:choose>	
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<c:choose>
					<c:when test='${member.gender=="1"}'>남자</c:when>
					<c:otherwise>여자</c:otherwise>
				</c:choose>	
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.phone}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="메인 페이지로 이동" 
					onclick="location.href='main.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>
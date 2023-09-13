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
<form method="post">
<!-- action을 빼도 된다. login.jsp 자체를 LoginServlet이 불러온 것. 
	마땅한 action이 없으면 자신을 불러온 페이지로 다시 되돌아간다. 되돌아갈 방식을 post로 정해준 것 -->
	<table align="center">
		<tr>
			<td colspan="2" align="center">로그인</td>
		</tr>
		<tr>
			<td align="center">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td align="center">레벨</td>
			<td><select name="lev">
				<option value="A">운영자</option>
				<option value="B">일반회원</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	<div style="color:red; text-align:center;">${message}</div>
</form>	
</body>
</html>
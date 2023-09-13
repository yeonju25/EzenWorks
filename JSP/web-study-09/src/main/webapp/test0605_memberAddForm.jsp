<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="test0605_memberAdd.jsp">
	<h2>멤버 정보 입력</h2>
	<table>
		<tr>
			<td> 이름 : </td>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td> 아이디 : </td>
			<td><input type="text" name="userid" size="20"></td>
		</tr>
		<tr>
			<td> 비밀번호 : </td>
			<td><input type="password" name="pwd" size="20"></td>
		</tr>
		<tr>
			<td> 이메일 : </td>
			<td><input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<td> 핸드폰 : </td>
			<td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td>
			<select name="admin">
				<option value = "0"> 사용자 </option>
				<option value = "1"> 관리자 </option>
			</select>
			</td>	
		</tr>
		<tr>
			<td><input type="submit" value="전송"></td>
			<td><input type="reset" value="취소"></td>
	</table>

</form>
</body>
</html>
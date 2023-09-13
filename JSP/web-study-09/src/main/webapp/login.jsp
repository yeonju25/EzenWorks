<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>

</head>
<body>
	<h2>로그인</h2>
	<form name="frm" method="post" action="login.do">
		<table>
			<tr>
				<td>아이디</td>						
				<td><input type="text" name="userid" value="${userid}"></td>
			</tr>   <!-- ${userid}의 용도는 회원가입 시 가입한 아이디가 입력칸에 바로 나타나도록 하기 위한 용도 -->
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" 
						onclick="return loginCheck()">&nbsp; &nbsp;
					<input type="reset" value="취소">&nbsp; &nbsp;
					<input type="button" value="회원가입"
						onclick="location.href='join.do'"> 
				</td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	
	</form>

</body>
</html>
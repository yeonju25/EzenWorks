<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>회원 전용 페이지</h2>
 
 <form method="get" action="logout.do"> 
 <!-- method 생략해도 되는데 생략되어 있으면 get이다. -->
 	<table>
 		<tr>
 			<td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td>
 		</tr>	
 		<tr>
 			<td colspan="2" align="center">
 				<input type="submit" value="로그아웃">&nbsp;&nbsp;
 				<input type="button" value="회원정보변경" onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
 			</td>	 		
 	</table>
 			
 </form>
 
</body>
</html>
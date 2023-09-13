<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 실제로는 DB에서 가져와야하는 값
String id="pinksung";
String pwd="1234";
String name="성윤정";

if( id.equals(request.getParameter("id")) && 
		pwd.equals(request.getParameter("pwd")) ) {
	// id, pwd가 같을 때만 쿠키 생성하고 client에 추가
	// 1. Cookie 객체 생성(username에 성윤정을 맵핑)
		Cookie c = new Cookie("username", "성윤정");
		response.addCookie(c);
		response.addCookie(new Cookie("id","pinksung"));
		response.addCookie(new Cookie("pwd","1234"));
%>

<h2> 성공적으로 로그인하셨습니다. </h2>
<p><a href="main.jsp">들어가기</a>
<%
} else{
%>
 <h2>로그인에 실패했습니다.</h2>
 <p><a href="loginForm.jsp">되돌아가기</a>
 <%
 }
 %>
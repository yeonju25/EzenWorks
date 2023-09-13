<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />
	
	<%
		com.saeyan.javabeans.MemberBean member2 = new com.saeyan.javabeans.MemberBean();
	%>
	
	자바빈 객체 생성 후 저장된 정보 출력 <br>
	이름 : <%=member.getName() %> <br>
	아이디 : <%=member.getUserid() %> <br>
	
	자바빈 변경 후 변경된 내용 출력하기 <br>
	<%
		member.setName("전수빈");
		member.setUserid("pinksung");
	%>
	이름 : <%=member.getName() %> <br>
	아이디 : <%=member.getUserid() %> <br>
</body>
</html>
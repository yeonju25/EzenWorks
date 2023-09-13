<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.saeyan.dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDAO memDao = MemberDAO.getInstance();
	//MemberDAO memDao = new MemberDAO(); 는 불가 : private 로 묶여있기 때문에 import해서 연결해주고 가져와야 한다.
	Connection conn= memDao.getConnection();
	out.println("DBCP 연결 성공!!");
%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.magic.dao.EmployeesDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 	EmployeesDAO empDao = EmployeesDAO.getInstance();
	Connection conn= empDao.getConnection();
	out.println("DBCP 연결 성공!!");
%>

</body>
</html>
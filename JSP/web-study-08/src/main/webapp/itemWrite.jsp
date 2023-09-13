<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%!
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String uid ="scott";
	String upw = "tiger";
	String sql = "select * from item";
	

%>
<!DOCTYPE html>
<html>
<head>
<style>
table { border : 2px solid }
table tr { border : 2px solid }
table tr td { border : 2px solid }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 완료된 정보</h2>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	conn = DriverManager.getConnection(url, uid, upw);
	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
%>
<table>
<% while(rs.next()){%>	
	<tr>
		<td><%out.println(rs.getString("name"));%></td>
		<td><%out.println(rs.getString("price"));%></td>
		<td><%out.println(rs.getString("description"));%></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>
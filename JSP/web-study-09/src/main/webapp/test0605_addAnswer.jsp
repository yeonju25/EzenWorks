<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try{
		//드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//데이터베이스 연결
		conn = DriverManager.getConnection(url, uid, upw);
		//데이터베이스 sql문장 쓰기
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, Integer.parseInt(request.getParameter("empno")));
		pstmt.setString(2, request.getParameter("ename"));
		pstmt.setString(3, request.getParameter("job"));
		pstmt.setInt(4, Integer.parseInt(request.getParameter("mgr")));
		pstmt.setString(5, request.getParameter("hiredate"));
		pstmt.setInt(6, Integer.parseInt(request.getParameter("sal")));
		pstmt.setInt(7, Integer.parseInt(request.getParameter("comm")));
		pstmt.setInt(8, Integer.parseInt(request.getParameter("deptno")));
		
		// 콘솔에 1이 뜨면 DB에 입력됐다는 뜻
		int result = pstmt.executeUpdate();
		System.out.println(result);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(pstmt != null) pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<h3>입력 성공</h3>
</body>
</html>
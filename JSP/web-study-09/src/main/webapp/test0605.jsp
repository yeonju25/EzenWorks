<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	String sql = "select * from emp";
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
			//데이터베이스 sql문장 실행, 실행 결과를 rs가 참조
			rs = pstmt.executeQuery(sql);
			
			
			while(rs.next()){
				out.println(rs.getString("EMPNO"));
				out.println(rs.getString("ENAME"));
				out.println(rs.getString("JOB"));
				out.println(rs.getString("MGR"));
				out.println(rs.getDate("HIREDATE"));
				out.println(rs.getInt("SAL"));
				out.println(rs.getString("COMM"));
				out.println(rs.getString("DEPTNO"));
				out.println("<br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>
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
	String sql2 = "insert into emp values(?,?,?,?,?,?,?,?)";
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
		
			
			// 테이블에 추가하기
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, 9999);
			pstmt.setString(2, "Kim");
			pstmt.setString(3, "MANAGER");
			pstmt.setInt(4, 7839);
			pstmt.setString(5, "1985-05-06");
			pstmt.setInt(6,1000);
			pstmt.setInt(7,100);
			pstmt.setInt(8,10);
			
			pstmt.executeUpdate();
		
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
	
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery(sql);	
		while(rs.next()){
			out.println(rs.getInt("EMPNO"));
			out.println(rs.getString("ENAME"));
			out.println(rs.getString("JOB"));
			out.println(rs.getInt("MGR"));
			out.println(rs.getDate("HIREDATE"));
			out.println(rs.getInt("SAL"));
			out.println(rs.getInt("COMM"));
			out.println(rs.getInt("DEPTNO"));
			out.println("<br>");
		}		
	
	%>


</body>
</html>
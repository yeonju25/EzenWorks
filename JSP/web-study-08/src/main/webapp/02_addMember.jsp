<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String upw = "tiger";
	
	String sql = "insert into member values(?,?,?,?,?,?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		
		try{
			//드라이브 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//DB연결
			conn = DriverManager.getConnection(url, uid, upw);
			
			//객체 생성 --> 미리 sql 실행...
			pstmt = conn.prepareStatement(sql);
			
			//? 부분을 입력폼에서 입력한 값으로 채운다.
			pstmt.setString(1, name);
			pstmt.setString(2, userid);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setInt(6, Integer.parseInt(admin));
			
			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{ // pstmt, conn 둘다 닫아줘야함 역순으로 닫아줌, try로 예외처리도 해줘야함
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
	
	
	<h3>회원 가입 성공</h3>
	<a href="01_allMember.jsp">회원 전체 목록 보기</a>
</body>
</html>
package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

// MemberDAO는 DB의 데이터와 입력받은 값을 비교하는 용도로 생성
// MemberVO는 로그인 정보들을 담으려는 용도로 생성
public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	// MemberDAO = 싱글톤패턴 
	// 싱글톤패턴 : 인스턴스가 하나만! 생성되고 그걸 static으로 올려놓고 계속 가져다 씀
	// 메모리 세이브에 굿
	
	public static MemberDAO getInstance() {
//      Class.forName("oracle.jdbc.driver.OracleDriver");
//      conn = DriverManager.getConnection(url, uid, upwd);
		return instance;
	}
	
	
	// 아래 내용이 위 18~19줄 주석처리한 코드의 역할 수행하는 것
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	// userid, pwd --> DB에 있는지 체크해 볼 것이다.
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pwd from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			//DB 연결
			conn = getConnection();
			//DB 선행으로 문장 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid); // 바인딩
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String getpwd = rs.getString("pwd");
				
				if(getpwd != null && getpwd.equals(pwd)) {
					result = 1; 	// 아이디, 비밀번호 일치
				}else {
					result = 0; 	// 아이디는 있으나 비밀번호 불일치
				}
			}else {
				result = -1;		// 존재하지 않는 아이디
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public MemberVO getMember(String userid) {
		
		MemberVO vo = null;
		
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection(); // DB연결
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
				// vo 안 각각의 변수에 담는다. 
				// 뭐를? DB에서 가져온 rs.get~들을!
				// setName의 name은 MemberVO vo의 name
				// rs.getString("name")의 name은 DB의 컬럼명
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return vo;		
	}
	
	public int updateMember(MemberVO vo) {
		int result = -1;
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// 이 순서는 위 sql 문에 적힌 순서
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setInt(4, vo.getAdmin());
			pstmt.setString(5, vo.getUserid());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int confirmID(String userid) {
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;		// 아이디가 존재함 
			}else {
				result = -1;	// 아이디 존재하지 않는다, 입력한 아이디 사용가능
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		int result = -1;
		String sql = "insert into member(name,userid,pwd,email,phone,admin) values(?,?,?,?,?,?)";
//		String sql = "insert into member values(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// 순서는 위 테이블이름(member) 뒤 괄호 안 순서로 작성
			// 200줄처럼 괄호 생략하고 쓸 수 있음, 그렇다면 순서는 DB안의 컬럼명 순서로 작성
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}


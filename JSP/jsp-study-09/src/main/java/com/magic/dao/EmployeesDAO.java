package com.magic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	public EmployeesDAO() {
	}
	
	// 싱글톤 패턴
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	// 입력한 정보가 DB에 존재하는지 체크
	public int userCheck(String id, String pwd, String lev) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where id=?";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(pwd.equals(rs.getString("pass"))){
					if(lev.equals(rs.getString("lev"))) {
						
						result = 3; // 일반회원
						
						if(lev.equals("A"))
							result = 2;	// 관리자
						
					}else {
						result = 1;	// 아이디 일치, 비번 일치, lev 불일치
					}
				} else {
					result = 0;	// 아이디 일치, 비번 불일치
				}
			}else {
				result = -1;	// 아이디 불일치
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public EmployeesVO getMember(String id) {
		EmployeesVO vo = new EmployeesVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where id=?";
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getString("enter"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)		rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int updateMember(EmployeesVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employees set pass=?, name=?, lev=?, gender=?, phone=? where id=?";
	
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getLev());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getId());
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 선생님 코드 insert
	public int insertMember(EmployeesVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employees values(?,?,?,?,sysdate,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLev());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { 
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 내가 해본 insert
//	public EmployeesVO insertMember(EmployeesVO vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "insert into employees(id, pass, name, lev, gender, phone) values (?,?,?,?,?,?)";
//		
//		try {
//			conn = getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getId());
//			pstmt.setString(2, vo.getPass());
//			pstmt.setString(3, vo.getName());
//			pstmt.setString(4, vo.getLev());
//			pstmt.setString(5, vo.getGender());
//			pstmt.setString(6, vo.getPhone());
//			
//			pstmt.executeUpdate();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try { 
//				if(pstmt != null)	pstmt.close();
//				if(conn != null)	conn.close();
//				
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return vo;
//	}
}


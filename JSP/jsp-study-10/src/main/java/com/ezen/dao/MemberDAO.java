package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.ezen.controller.MovieListServlet;
import com.ezen.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}

	public List<MemberVO> selectAllMovies(){
		List<MemberVO> list = new ArrayList<>();

		String sql = "select * from movie order by code";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertMovie(MemberVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into movie values(movie_seq.nextval,?,?,?,?,?,?)";
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getPoster());
			pstmt.setString(6, vo.getSynopsis());
		
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public MemberVO getMovie(int code) {
		String sql = "select * from movie where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberVO vo = new MemberVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCode(code);
				vo.setTitle(rs.getString("title"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPrice(rs.getInt("price"));
				vo.setSynopsis(rs.getString("synopsis"));
				vo.setPoster(rs.getString("poster"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt, rs);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public int updateMovie(MemberVO vo) {
		String sql = "update movie set title=?, director=?, actor=?, price=?, synopsis=?, poster=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		int result = -1;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getDirector());
			pstmt.setString(3, vo.getActor());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setString(5, vo.getSynopsis());
			pstmt.setString(6, vo.getPoster());
			pstmt.setInt(7, vo.getCode());
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteMovie(int code){
		int result = -1;
		String sql = "delete from movie where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBManager.close(conn, pstmt);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}

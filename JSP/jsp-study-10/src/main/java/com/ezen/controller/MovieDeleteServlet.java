package com.ezen.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;


@WebServlet("/movieDelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDAO = MemberDAO.getInstance();
		MemberVO vo = mDAO.getMovie(Integer.parseInt(request.getParameter("code")));
		request.setAttribute("movie", vo);
		
		String url = "deleteMovie.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDAO = MemberDAO.getInstance();
		int code = Integer.parseInt(request.getParameter("code"));
		int result = mDAO.deleteMovie(code);
		
		if(result == 1) {
			response.sendRedirect("movieList.do");
		}
		
		
	}

}

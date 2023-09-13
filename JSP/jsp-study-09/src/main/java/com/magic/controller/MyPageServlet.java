package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String url = "login.do";
		
		if(session != null) {
			url = "mypage.jsp";
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}else {
			response.sendRedirect(url);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		EmployeesVO vo = new EmployeesVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(request.getParameter("gender"));
		vo.setPhone(request.getParameter("phone"));
		
		EmployeesDAO empDAO = EmployeesDAO.getInstance();
		empDAO.updateMember(vo);
		
		vo = empDAO.getMember(vo.getId());
		request.setAttribute("member", vo);
		request.setAttribute("message", "회원 정보가 수정되었습니다.");
		session.setAttribute("loginUser", vo);
		
		String url = "joinSuccess.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}

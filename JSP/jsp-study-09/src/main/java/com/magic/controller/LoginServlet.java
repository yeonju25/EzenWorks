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

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url = null;
		
		EmployeesDAO empDao = EmployeesDAO.getInstance();
		int result = empDao.userCheck(id, pwd, lev);

		if(result == 2 || result == 3) {
			EmployeesVO eVo = new EmployeesVO();
			eVo = empDao.getMember(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", eVo);
			session.setAttribute("result", result);
			url = "main.jsp";
			
		}else {
			url = "login.jsp";
			if(result == 1) {
				request.setAttribute("message", "레벨이 틀립니다.");
			}else if(result == 0){
				request.setAttribute("message", "비밀번호가 틀립니다.");
			}else {
				request.setAttribute("message", "아이디가 틀립니다.");				
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}

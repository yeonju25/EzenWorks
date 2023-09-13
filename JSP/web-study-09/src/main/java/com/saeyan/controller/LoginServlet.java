package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		// new MemberDAO가 안되는 이유는 MemberDAO의 생성자가 private이기 때문
		int result = mDao.userCheck(userid, pwd);
		
		if(result == 1) {
			//MemberVO에 로그인 성공한 아이디 정보 저장
			MemberVO mVo = mDao.getMember(userid);
			//session은 아이디패스워드 데이터를 login.jsp로 던져주기 위해 씀
			HttpSession session= request.getSession();
			// requset.getSession() : 세션이 있으면 가져오고 없으면 새로 세션 생성한다.
			session.setAttribute("loginUser", mVo); // loginUser값에 mVo를 바인딩?
			request.setAttribute("message", "로그인 성공!");
			url = "main.jsp";
		}else if(result == 0) {
			request.setAttribute("userid", userid);
			//비번 불일치해도 아이디는 그대로 화면에 있도록 세팅하기
			
			request.setAttribute("message", "비번 불일치!");
		}else {
			request.setAttribute("message", "존재하지 않는 아이디");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}

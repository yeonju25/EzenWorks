package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCheckPassFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// BoardServlet?command=board_check_pass_form&num=1로 날린다고 가정
		// forward로 날리면 가지고 있는 num값이 전달되지만 redirect로 날리면 num값이 전달되지 않는다...?????

		String url = "/board/boardCheckPass.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}


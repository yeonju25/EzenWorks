package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// view화면 볼때 : 리스트에서 이름 클릭하면 BoardServlet?command=board_view$num=${board.num}이 넘어옴
		
		// 1. 브라우저에서 command(board_list) 요청 /BoardServlet?command=board_list
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		// 2. ActionFactory() 가져와서 af에 넣어줌
		ActionFactory af = ActionFactory.getInstance();
		
		// 3. action이  ActionFactory 안에 getAction 을 참조
		Action action = af.getAction(command);  //action = new BoarderListAction();
		
		// 6. if문 실행
		if(action != null)
			action.execute(request, response);
		// 7. action != null 이면 BoardListAction.java 안의 execute 실행
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}

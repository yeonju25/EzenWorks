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
	
		// 주소창에 친 커맨드 값을 getParameter로 받아옴
		String command = request.getParameter("command");
		System.out.println("command: "+ command);
		
		ActionFactory af = ActionFactory.getInstance(); // 싱글톤으로 ActionFactory 객체 만들기
		Action action = af.getAction(command);
		// 23줄이 수행되면 action = new BoardListAction();이 되는 것
		// BoardListAction은 action 인터페이스를 구현한 클래스, 그래서 Action action = new BoardListAction();이 가능한 것, 구현한거 아니면 불가능~
		
		if(action != null)
			action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

}

package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;

//컨트롤러
public class BoardListAction implements Action{

	//dopost 대신
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO bDao =BoardDAO.getInstance();
		List<BoardVO> list = bDao.selectAllBoard();
		//DAO 에서 전체데이타 담아서 list에 넣어줌
		
		request.setAttribute("boardList",list); //데이타가 담겨있는 전체 list 를 출력하려면 ${boardList}

		String url = "/board/boardList.jsp";
		
		 // 8. url (boardList.jsp) 실행
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}

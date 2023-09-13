package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> list = bDao.selectAllBoard();

		request.setAttribute("boardList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}

package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.controller.action.BoardViewAction;
import com.saeyan.controller.action.BoardWriteAction;
import com.saeyan.controller.action.BoardWriteFormAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) { //command = board_list
	      Action action = null;
	      System.out.println("ActionFactory : " + command);
	      
	      // command(board_list) 랑 ("board_list") 같다면 BoardListAction.java 에 있는 BoardListAction 실행
	      if(command.equals("board_list")) {
	         action = new BoardListAction();  //BoardListAction()을 action에 담아줌 //객체생성
	      }else if(command.equals("board_write_form")) {
	         action = new BoardWriteFormAction();
	      }else if(command.equals("board_write")) {
	         action = new BoardWriteAction();
	      }else if(command.equals("board_view")) {
	    	  action = new BoardViewAction();
	      }
	      
	      return action; // 5. BoardServlet.java 줄로 return
	   }

}

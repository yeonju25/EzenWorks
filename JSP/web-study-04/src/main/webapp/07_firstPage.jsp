<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "page man");
	request.setAttribute("name", "request man");
	session.setAttribute("name", "session man");
	application.setAttribute("name", "application man");
	
	System.out.println("firstPage.jsp : ");
	System.out.println("하나의 페이지 속성 : "+pageContext.getAttribute("name"));
	System.out.println("하나의 요청 속성 : "+request.getAttribute("name"));
	System.out.println("하나의 세션 속성 : "+session.getAttribute("name"));
	System.out.println("하나의 어플리케이션 속성 : "+application.getAttribute("name"));
	
	request.getRequestDispatcher("07_secondPage.jsp").forward(request, response);
	// 내가 가지고 있는 값을 다음 페이지로 넘겨주겠다 > forward방식으로 넘겨
	// 내가 가지고 있는 값을 다다음 페이지까지 다 넘기겠다 > session에 담아서 넘겨
	// 어플리케이션은 잘 안씀, 리퀘스트랑 세션만 잘 기억하세요~
%>
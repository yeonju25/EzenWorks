<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age<=19){
%>		
	<%-- Script 코드를 넣어야하면 이렇게 중간에 끊어줘야 함 --%>
		<script type="text/javascript">
			alert("19세 이하는 입장 불가");
			history.go(-1);
		</script>
	
<%	
	}else{
		request.setAttribute("name", "팔달문");
		request.setAttribute("addr", "경기도 수원시");
		RequestDispatcher dis = request.getRequestDispatcher("05_forwardResult.jsp");
		dis.forward(request, response);
	}

%>
    
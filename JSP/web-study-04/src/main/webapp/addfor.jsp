<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1부터 <%= request.getParameter("num") %>까지의 자연수 합 구하기</h1>
	<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for(int i=1; i<num; i++){
		sum += i;
	%> <%= i %> +
	<%
	}
	sum += num;
	%>
	
	<%= num %> = <%=sum %>
</body>
</html>
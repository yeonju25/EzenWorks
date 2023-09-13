<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String str = "안녕하세요";
	int a = 5, b = -5;
	
	public int abs(int n){
		return a>b ? a : -b;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		out.print(str+"<br>");
		out.print(a+"의 절대값 : "+abs(a)+"<br>");
		out.print(b+"의 절대값 : "+abs(b)+"<br>");
	%>
	<%= a %> 절대값 : <%=abs(a) %>
	
</body>
</html>
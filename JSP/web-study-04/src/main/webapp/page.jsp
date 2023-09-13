<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>검색 엔진 정보 페이지</h1>
<h2>검색 엔진을 선택하세요.</h2>
<select name="option" id="option">
<option value="1">네이버</option>
<option value="2">다음</option>
<option value="3">네이트</option>
<option value="4">구글</option>
</select>

<input type="submit" value ="확인">
<%
 request.getRequestDispatcher("pagemain.jsp").forward(request, response);
%>

</body>
</html>
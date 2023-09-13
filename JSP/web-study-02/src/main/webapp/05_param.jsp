<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
 
</head>
<body>
	<!-- submit버튼을 클릭하면 url주소가 ParamServlet을 get방식으로 찾아간다. doGet메소드 실행 -->
	<form name="frm" method="get" action="ParamServlet">
		아이디 : <input type="text" name="id"><br>
		나&nbsp;&nbsp;이 : <input type="text" name="age"><br>
		<input type="submit" value="전송" onclick="return check()">
	</form>
	<!-- GET방식으로 보내면 URL에 쿼리스트링으로 입력한 값 붙어서 날아가고
		POST방식으로 보내면 URL에 입력한 값 나오지 않는다. -->
	<!-- head에 script추가하고 form에 name 추가하고 마지막 input submit에
		onclick return 함수이름 치면 잘못 입력했을 때 안내창 뜨는 스크립트 설정 완료 
		param.js파일에 document.frm.id.focus();는 그 자리에 커서 찍어주는 역할
		유효성 체크 : 저렇게 무언가를 입력 안하면 넘어가지 않도록 하는 것 -->	
</body>
</html>
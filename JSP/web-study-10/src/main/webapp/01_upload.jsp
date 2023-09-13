<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.do" method="post" encType="multipart/form-data">
		글쓴이 : <input type="text" name="name"><br>
		제 목 : <input type="text" name="title"><br>
		1. 파일 저장하기 : <input type="file" name=uploadFile1><br> <!-- "uploadFile" 따옴표 있어도 되고 없어도 됨 -->
		2. 파일 저장하기 : <input type="file" name=uploadFile2><br> <!-- "uploadFile" 따옴표 있어도 되고 없어도 됨 -->
		3. 파일 저장하기 : <input type="file" name=uploadFile3><br> <!-- "uploadFile" 따옴표 있어도 되고 없어도 됨 -->
		<input type="submit" value="전송">
	</form>
</body>
</html>
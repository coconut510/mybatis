<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원 정보 출력 </title>
</head>
<body>
	<h1>학생 정보</h1>
	학생 번호 : ${student.studentNo }<br>
	학생 이름: ${student.studentName }<br>
	학생 전화번호: ${student.studentTel }<br>
	학생 이메일 : ${student.studentEmail }<br>
	학생 주소: ${student.studentAddr }<br>
</body>
</html>
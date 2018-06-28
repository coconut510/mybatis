<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/editUserInfo" method="post">
		아이디 : <input type="text" readonly value="${user.userId}" name="userId"/><br>
		비밀번호 :<input type="password" value="${user.userPw}" name="userPw" /><br>
		비밀번호재입력 :<input type="password" /><br>
		닉네임 : <input type="text" value="${user.userNick}"  name="userNick"/><br> 
		전화번호 : <input type="text" value="${user.userTel}" name="userTel"/><br>
		<input type="submit" value="아이디 수정">
	</form>
</body>
</html>
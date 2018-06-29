<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyInfo</title>
</head>
<body>
	<form action="/myInfoEdit" method="post">
		ID : ${mem.memberId}<br>
		PW : <input type="password" value="${mem.memberPw}" name="memberPw"/><br>
		PW_re : <input type="password" value="${mem.memberPw}" /><br>
		이름 : ${mem.memberName}<br>
		지역 : ${mem.memberAddr }<br>			
		성별 : 	
				<c:if test="${mem.gender.equals('남')}">
					<input type="radio" name="select" checked disabled />남성
					<input type="radio" name="select" disabled/>여성<br>
				</c:if>
				<c:if test="${mem.gender.equals('여')}">
					<input type="radio" name="select" disabled/>남성
					<input type="radio" name="select" checked disabled/>여성<br>
				</c:if>
		취미 : ${mem.hobby}<br>
		가입일 : ${mem.regDate }<br>
	<input type="submit" value="변경하기"/>
	</form>
</body>
</html>
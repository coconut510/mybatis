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
	<c:forEach items="${list}" var="user">
		유저 번호 : ${user.userNo}<br>
		<c:if test="${user.userId != null}">
			 유저 ID : ${user.userId}<br>
		</c:if>
		<c:if test="${user.userPw != null}">
			유저 PW : ${user.userPw}<br>
		</c:if>
		<c:if test="${user.userName != null}">
			유저 이름 : ${user.userName}<br>
		</c:if>
		<c:if test="${user.userAddr != null}">
			유저 Addr : ${user.userAddr}<br>
		</c:if>		
		유저 가입일 : ${user.regDate}
		<hr>
	</c:forEach>
</body>
</html>
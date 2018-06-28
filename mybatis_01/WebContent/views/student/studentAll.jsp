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
	<c:forEach items= "${list}" var="std">
		학생 번호 : ${std.studentNo}<br>
		학생 이름 : ${std.studentName}<br>
		학생 주소 : ${std.studentAddr}<br>
		학생 전번 : ${std.studentTel}<br>
		학생 이멜 : ${std.studentEmail}<br>
		<hr>
	</c:forEach>
</body>
</html>
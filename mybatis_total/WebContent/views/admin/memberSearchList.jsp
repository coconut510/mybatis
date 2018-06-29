<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	th, td{
		border:1px solid black;
	}
</style>
</head>
<body>
	<table style="border:1px solid black;">
		<tr ><th>번호</th><th>ID</th><th>이름</th><th>지역</th><th>성별</th><th>취미</th><th>가입일</th></tr>
		<c:forEach items="${list}" var="m">
			<tr><td> ${m.memberNo}</td><td> ${m.memberId}</td>
			<td> ${m.memberName}</td>
			<td> ${m.memberAddr}</td>
			<td> ${m.gender}</td>
			<td> ${m.hobby}</td>
			<td> ${m.regDate}</td></tr>
		</c:forEach>
	</table>
</html>
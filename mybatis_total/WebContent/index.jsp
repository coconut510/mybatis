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
<c:choose>
	<c:when test="${sessionScope.member==null}">
		회원 로그인
		<br>
		<form action="/memberLogin" method="post">
			ID : <input type="text" name="memberId"/><br>
			PW : <input type="password" name="memberPw"/><br>
			<input type="submit" value="로그인"/>
		</form>
		<br>
		<a href="/views/member/join.html">회원가입</a>
	</c:when>
	<c:when test="${member!=null}">
		<h2>[${member.memberName }]님 환영합니다</h2>
		<br>
		<a href="/logout">로그아웃</a><br>
		<a href="/myInfo">마이정보 보기</a><br>
		<a href="/deleteMember">회원탈퇴</a><br>
		<c:if test="${member.memberId.equals('admin')}">
			<a href="/memberAll">전체회원 보기[관리자전용]</a><br>
		</c:if>
	</c:when>
</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>

<c:if test="${empty sessionScope.id}">
	<c:redirect url="/member/login"></c:redirect>
</c:if>

<h1>메인화면</h1>
${sessionScope.id}님 로그인하셨습니다.
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/info">정보조회</a><br>
<a href="${pageContext.request.contextPath }/member/update">정보수정</a><br>
<a href="${pageContext.request.contextPath }/member/delete">정보삭제</a><br>

<c:if test="${!empty sessionScope.id}">
	<c:if test="${sessionScope.id eq 'admin'}">
		<a href="${pageContext.request.contextPath }/member/list">회원목록</a><br>
	</c:if>
</c:if>

<c:if test="${!empty sessionScope.id}">
	<a href="${pageContext.request.contextPath }/board/write">글쓰기</a><br>
</c:if>

<a href="${pageContext.request.contextPath }/board/list">글목록</a><br>
</body>
</html>
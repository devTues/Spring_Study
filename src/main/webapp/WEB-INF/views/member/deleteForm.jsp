<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/deleteForm.jsp</title>
</head>
<body>
<h1>회원정보삭제</h1>
<%
// String id = (String)session.getAttribute("id");
%>
<h1>회원정보삭제</h1>
<form action="${pageContext.request.contextPath }/member/deletePro" method="post">
	아이디 : <input type="text" name="id" value="${sessionScope.id}" readonly><br>
	비밀번호: <input type="password" name="pass"><br>
	<input type="submit" value="회원정보삭제">
</form>


</body>
</html>
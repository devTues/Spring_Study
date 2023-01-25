<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<%
// 세션값이 null이면 로그인페이지로 이동
// String id=(String)session.getAttribute("id");
// if(id==null){
// 	response.sendRedirect("loginForm.jsp");
// }
%>

<h1>메인화면</h1>
<%//=session.getAttribute("id") %> 님 로그인하셨습니다.
<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a><br>
<a href="${pageContext.request.contextPath }/member/info">정보조회</a><br>
<a href="${pageContext.request.contextPath }/member/update">정보수정</a><br>
<a href="${pageContext.request.contextPath }/member/delete">정보삭제</a><br>
<%// admin사용자만 보이게 설정 
// 문자열 비교 => 문자열.equals(문자열)
// id null이면 equals 사용못함
%>
<%
// if(id != null) {
// 	if(id.equals("admin")) {
	%><a href="${pageContext.request.contextPath }/member/list">회원목록</a><br>
	<%
// 	}
// }


// if(id != null) {
	%><a href="${pageContext.request.contextPath }/board/write">글쓰기</a><br><%
// }

%>


<!-- <a href="../board/writeForm.jsp">글쓰기</a><br> -->
<!-- <a href="../board/updateForm.jsp">글수정</a><br> -->
<a href="${pageContext.request.contextPath }/board/list">글목록</a><br>
</body>
</html>
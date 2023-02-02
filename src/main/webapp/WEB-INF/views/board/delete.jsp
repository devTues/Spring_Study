<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/delete.jsp</title>
</head>
<body>
<%
// board/delete.jsp
// deleteForm.jsp?num=1 (num값 가져옴)
int num = Integer.parseInt(request.getParameter("num"));

//BoardDAO 객체생성 기억장소 할당=> dao 기억장소 주소 저장
BoardDAO dao=new BoardDAO();

//리턴할형없음 dao주소를 통해서 deleteBoard(int num) 메서드 정의

// 디비작업 주소를 통해서 deleteBoard(num) 호출
dao.deleteBoard(num);

// 글삭제 후 글목록으로 이동
response.sendRedirect("list.jsp");
%>

</body>
</html>
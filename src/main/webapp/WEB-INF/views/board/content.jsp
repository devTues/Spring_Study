<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/content.jsp</title>
</head>
<body>
<h1>글내용</h1>
<%
//content.jsp?num=1
int num = Integer.parseInt(request.getParameter("num"));

// 객체생성 기억장소 할당 => dao 기억장소 주소 저장
BoardDAO dao = new BoardDAO();
// 조회수 증가 readcount 1 증가
// update board set readcount=readcount+1 where num=?
// 리턴할형 없음 updateReadcount(int num) 메서드 정의
// dao주소를 통해서 updateReadcount(num) 메서드 호출
dao.updateReadcount(num);
// BoardDTO 리턴할형 getBoard(int num) 메서드 정의
// dao 주소를 통해서 메서드 호출 => 리턴할형 BoardDTO
BoardDTO dto = dao.getBoard(num);
%>
<table border="1">
<tr><td>글번호</td><td><%=dto.getNum() %></td></tr>
<tr><td>작성자</td><td><%=dto.getName() %></td></tr>
<tr><td>등록일</td><td><%=dto.getDate() %></td></tr>
<tr><td>조회수</td><td><%=dto.getReadcount() %></td></tr>
<tr><td>제목</td><td><%=dto.getSubject() %></td></tr>
<tr><td>글내용</td><td><%=dto.getContent() %></td></tr>

<tr><td colspan="2">
<%
// 세션값 가져오기
String id=(String)session.getAttribute("id");

// 글쓴이와 로그인(세션값) 일치하면 => 글수정, 글삭제 버튼 보이기
if(dto.getName().equals(id)) {
	%>
<input type="button" value="글수정"
onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">
<input type="button" value="글삭제"
onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">
	<%
}
%>


<!-- <input type="button" value="글수정" -->
<%-- onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'"></td></tr> --%>
<!-- <tr><td><input type="button" value="글삭제" -->
<%-- onclick="location.href='deleteForm.jsp?num=<%=dto.getNum()%>'"></td></tr> --%>
<input type="button" value="글목록"
onclick="location.href='list.jsp'">
</table>
<a href="../member/main.jsp">메인화면</a><br>
</body>
</html>
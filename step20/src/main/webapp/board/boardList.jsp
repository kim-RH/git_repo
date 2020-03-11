<%@page import="java.util.ArrayList"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style type="text/css">
#currentPaging{color: red; text-decoration: underline;}
#paging{color: blue; text-decoration: none;}
#subjectA:link{color: black; text-decoration: none;}
#subjectA:visited{color: black; text-decoration: none;}
#subjectA:action{color: black; text-decoration: none;}
#subjectA:hover{color: red; text-decoration: underline;}
</style>
<script type="text/javascript">
	function isLogin(seq) {
		if(${memId == null}) {
			alert("먼저 로그인 하세요.");
		} else {
			location.href="boardView.do?seq="+seq+"&pg="+${pg};
		}
	}
</script>
</head>
<body>
<table border="1">
	<tr bgcolor="#ffff00">
		<th width="70">글번호</th>
		<th width="200">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="70">조회수</th>
	</tr>
<c:forEach var="dto" items="${list}">
	<tr bgcolor="#ffffcc" align="center">
		<td>${dto.seq}</td>
		<td><a href="#" id="subjectA" onclick="isLogin(${dto.seq})">${dto.subject}</a></td>
		<td>${dto.id}</td>
		<td>${dto.logtime}</td>
		<td>${dto.hit}</td>
	</tr>
</c:forEach>
<!-- 페이징 처리 -->
	<tr>
		<td colspan="5" align="center">
			<c:if test="${startPage>3 }">
			[<a href="boardList.do?pg=${startPage-1 }" id="paging">이전</a>]
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${i==pg}">
					[<a href="boardList.do?pg=${i}" id="currentPaging">${i}</a>]
				</c:if>
				<c:if test="${i!=pg}">
					[<a href="boardList.do?pg=${i}" id="paging">${i}</a>]
				</c:if>
			</c:forEach>
			<c:if test="${endPage<totalP}">
			[<a href="boardList.do?pg=${endPage+1}" id="paging">다음</a>]
			</c:if>
		</td>
	</tr>
</table>
<br>

<c:if test="${memId==null }">
	<a href="../member/loginForm.do">로그인</a><br>
</c:if>
<c:if test="${memId!=null }">
	<a href="boardWriteForm.do">새 글쓰기</a><br>
	<a href="logout.do">로그아웃</a><br>
</c:if>

</body>
</html>
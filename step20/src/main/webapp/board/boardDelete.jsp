<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<script type="text/javascript">
	if (${count > 0}) {
		alert("삭제 성공!");
	} else {
		alert("삭제 실패!");
	}
	location.href="boardList.do?pg=${pg}";
</script>
</head>
<body>

</body>
</html>
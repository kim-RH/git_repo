<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function () {
		if(${su > 0}) {
			alert("등록 완료");
			location.href="boardList.do";
		} else {
			alert("등록 실패");
			history.back();
		}
	}
</script>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="login.do" method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="">
		</td>
	</tr>
</table>
<a href="../board/boardList.do">글 목록</a>
</form>
</body>
</html>
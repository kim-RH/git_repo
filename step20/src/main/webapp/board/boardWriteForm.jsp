<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
    
<!-- include plugin -->
<script src="[folder where script is located]/[plugin script].js"></script>
<script>
//id가 description인 것을 summernote 방식으로 적용하라는 의미이다.
//높이와 넓이를 설정하지 않으면 화면이 작게 나오기때문에 설정해주어야 한다.
$(function(){
    $("#description").summernote({
    	lang : 'ko-KR',
        height : 300,
        width : 800,
        fontNames: ['소야뜰9',  'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
    });
});
</script>
<script src="../summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript" src="../script/boardScript.js?v=1"></script>
</head>
<body>
<form action="boardWrite.do" method="post" name="boardWriteForm">
<table border="1">
	<tr>
		<th width="50">제목</th>
		<td><input type="text" name="subject" size="59"></td>
	</tr>
	<tr>
		<th width="50">내용</th>
		<td><textarea rows="15" cols="45" name="content" id="description"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="글작성" onclick="checkBoardWrite()">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
<a href="../board/boardList.do">목록가기</a>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
</head>
<body>
<h3>이미지 등록</h3>
<form action="imageboardWrite" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>상품코드</td>
			<td><input type="text" name="imageId" value="img_" size="40"></td>
		</tr>
		<tr>
			<td>상품명</td>
			<td><input type="text" name="imageName" size="45"></td>
		</tr>
		<tr>
			<td>단가</td>
			<td><input type="text" name="imagePrice" size="40"></td>
		</tr>
		<tr>
			<td>수량</td>
			<td><input type="text" name="imageQty" size="40"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="imageContent"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="file" name="img" size="40"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="이미지등록">
				<input type="reset" value="다시 작성" >
			</td>
		</tr>
	</table>

</form>
</body>
</html>
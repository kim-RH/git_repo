<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록 결과</title>
</head>
<body>
<p>상품 코드 :${dto.imageId}</p>
<p>상품명 :${dto.imageName}</p>
<p>상품가격 :${dto.imagePrice}</p>
<p>상품수량 :${dto.imageQty}</p>
<p>상품설명 :${dto.imageContent}</p>
<p>파일 이름 :${dto.image1}</p>
<p><img alt="이미지" src="../storage/${dto.image1}"></p>
<!-- 새로고침해야 그림을 볼 수 있지만, 정식서버에서는 제대로 동작함 -->
</body>
</html>
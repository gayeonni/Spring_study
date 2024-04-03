<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Human 객체의 정보 확인하기</h1>
    human의 이름: ${human.name}<br>
    human의 나이: ${human.age}<br>
    human의 주소: ${human.address}<br>
    human의 전체 정보: ${human}<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/reqres/human" method="get">
        이름: <input type="text" name="name"><br>
        나이: <input type="number" name="age"><br>
        주소: <input type="text" name="address"><br>
        <button>제출</button>
    </form>
</body>
</html>
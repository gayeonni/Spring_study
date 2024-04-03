<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- action은 목적지로 해당 폼의 데이터를 어디로 보낼지 작성한다.
    method는 전송방법, get은 url 뒤에 붙여서, port는 req body에 보낸다. -->
    <form action="/reqres/login" method="post">
        <!-- input은 폼 내부에서 데이터를 전송할 양식을 지정할 때 사용한다.
            name은 어떤 변수에 데이터를 담아서 보낼지 결정한다.-->
        <input type="text" name="id">
        <!-- pw 입력할 input 작성 -->
        <input type="password" name="pw">

        <button>로그인하기</button>
    </form>
</body>
</html>
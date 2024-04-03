<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>게시물 작성 폼</h1>
    <form action="board-write" method="post">
        작성자: <input type="text" name="writer"><br>
        본문: <input type="text" name="content"><br>
        <!-- 폼 양식에는 포함되지 않으나 숨겨서 보낼 값 지정
        name이 boardNum, value가 0이므로 boardNum 변수에 0을 보냄-->
        <input type="hidden" name="boardNum" value="0">
        <button>글쓰기</button>
        </form>
    </form>
</body>
</html>
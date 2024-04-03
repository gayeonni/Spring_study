<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        
    <h2>게시글 상세 페이지입니다.</h2>
    게시글 목록: ${board}

    <c:forEach var="board" items="${boardList}">
        글 번호: ${board.boardNum}, 작성자: ${board.writer}
        , 게시시간: ${board.createdAt} <br>
        <h3>본문: ${board.content}</h3>   
    </c:forEach>

    <h3>글번호: ${board.boardNum}</h3>
    <h3>작성자: ${board.writer}</h3>
    <h3>본문: ${board.content}</h3>
    <h3>작성시각: ${board.createdAt}</h3>

    <br>
    <!-- 목록 페이지로 돌아가는 링크 -->
    <a href="/board/list">목록</a>
    <br>
    <form action="/board/delete" method="post">
        <input type="hidden" name="boardNum" value="${board.boardNum}">
        <button>삭제하기</button>
    </form>

    
</body>
</html>
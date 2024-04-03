<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h2>게시판 글 목록입니다.</h2>
    게시글 목록: ${boardList}

    <!-- .jsp 파일에서 boardList에 든 글 목록을 하나하나의 글로 
    바꿔서 화면에 표시한다. 이때 Jstl의 c:forEach를 사용한다.
    var의 변수에 items의 리스트를 번갈아가면서 지정한다.-->
    <c:forEach var="board" items="${boardList}">
        <h3>글 번호: ${board.boardNum}, 작성자: ${board.writer},
            본문: ${board.content}, 게시시간: ${board.createdAt},
            <a href="/board/detail/${board.boardNum}">디테일페이지로</a>
        </h3>
    </c:forEach>

    <button><a href="/board/write">글쓰기</a></button>

    
</body>
</html>
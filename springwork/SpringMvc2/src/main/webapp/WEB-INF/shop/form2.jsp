<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-17
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>502 jsp study</title>
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
          rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<body>
<form action="./process2" method="post">
    상품명 : <input type="text" name="sang"><br>
    수량 : <input type="number" name="su"><br>
    단가 : <input type="number" name="dan" min="1" max="10"><br>
    사진 :
    <select name="photo">
        <c:forEach var="no" begin="1" end="9">
            <option value="0${no}.png">${no}번 이미지</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">전송</button>
</form>
</body>
</html>

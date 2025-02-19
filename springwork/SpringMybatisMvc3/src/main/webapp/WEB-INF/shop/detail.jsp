<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-19
  Time: 오전 10:45
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

        div .p-list {
            width: 120px;
            height: 500px;
            overflow-y: auto;
        }

        div .p-list img {
            width: 100px;
            height: 100px;
            border: 1px solid gray;
            margin-bottom: 10px;
        }

        .photo {
            cursor: pointer;
            margin-bottom: 10px;
        }

        div .m-photo {
            height: 500px;
        }

        div .m-photo img {
            width: 400px;
            height: 500px;
            border: 3px solid black;
            margin-left: 50px;
        }

        #scolor {
            background-color: ${dto.scolor};
            width: 30px;
            height: 30px;
            border: 1px solid black;
            border-radius: 100px;
            position: relative;
            left: 150px;
            top: -30px;
        }

        .container {
            margin-top: 40px;
        }

        .btn1 {
            width: 120px;
            margin-right: 30px;
            border-radius: 5px;
        }

        .description {
            margin: 30px 0 30px 150px;
        }
    </style>
</head>
<body>
<%--<div style="margin: 30px;">--%>
<div class="container">
    <div style="display: flex; margin:auto;">
        <div class="p-list">
            <c:forEach var="photo" items="${photoList}">
                <img src="../save/${photo}" class="photo">
            </c:forEach>
        </div>
        <div class="m-photo">
            <img src="../save/${dto.mainphoto}">
        </div>
    </div>
    <div class="description">
        <h5>
            <mark>상품명 : ${dto.sangpum}</mark>
        </h5>
        <h5>가 격 : ${dto.sprice}</h5>
        <div style="display: flex">
            <h5>색 상 : ${dto.scolor}
                <div id="scolor"></div>
            </h5>
        </div>
        <h5>입고일 : ${dto.ipgoday}</h5>
        <h5>등록일 : <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></h5>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-sm btn-success btn1" id="btnRegi">상품 등록</button>
        <button type="button" class="btn btn-sm btn-success btn1" id="btnList">목록</button>
        <button type="button" class="btn btn-sm btn-success btn1" id="btnUpda">수정</button>
        <button type="button" class="btn btn-sm btn-success btn1" id="btnDele">삭제</button>
    </div>
</div>
</body>
</html>
<script>
    $(".photo").click(function () {
        $(".m-photo>img").attr("src", $(this).attr("src"));
    });
    $("#btnRegi").click(function () {
        location.href = "./addform";
    });
    $("#btnList").click(function () {
        location.href = "./list";
    });
    $("#btnUpda").click(function () {
        location.href = "./updateform?num=${dto.num}";
    });
    $("#btnDele").click(function () {
        if(confirm("삭제하겠습니까?")){
            location.href = "./delete?num=${dto.num}";
        }
    });
</script>
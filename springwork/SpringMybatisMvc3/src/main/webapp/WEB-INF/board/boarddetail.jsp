<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-26
  Time: 오후 3:58
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

        .w-photo {
            width: 40px;
            height: 40px;
            border-radius: 100px;
            position: relative;
            top: -10px;
        }

        .files img {
            width: 120px;
            height: 120px;
            border-radius: 20px;
            margin: 20px;
        }

        .files {
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<%--   로그인 안 된 경우 경고 후 이전 페이지로 이동  --%>
<c:if test="${sessionScope.loginstatus==null}">
    <script>
        alert("회원 게시판입니다\n먼저 로그인을 해주세요")
        history.back();
    </script>
</c:if>
<div style="margin: 30px;">
    <h2>${dto.subject}</h2>
    <div class="writer-box">
        <img src="${naverurl}/member/${profile}" onerror="this.src='../save/noimage.png'"
             class="w-photo">
        <div style="display: inline-block; margin-left: 10px;">
            <span>
                ${dto.writer}
            </span>
            <br>
            <span style="color: gray; font-size: 12px;">
                <fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd HH:mm"/>
                &nbsp;&nbsp;조회&nbsp;${dto.readcount}
            </span>
        </div>
    </div>
    <pre style="margin-top: 30px; font-size: 15px;">
        ${dto.content}
    </pre>
    <div class="files">
        <c:forEach var="file" items="${files}">
            <img src="${naverurl}/board/${file}" alt="">
        </c:forEach>
    </div>
    <div style="margin-top: 30px; display: flex;">
        <div>
            <button type="button" class="btn btn-success btn-sm" style="width: 80px;"
                    onclick="location.href='./writeform'">
                <i class="bi bi-pencile-fill"></i>
                글쓰기
            </button>
            <button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
                    onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel }&pageNum=${pageNum}'">
                답글쓰기
            </button>
            <c:if test="${sessionScope.loginid==dto.myid}">
                <button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
                        onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">
                    수정
                </button>
                <button type="button" class="btn btn-outline-secondary btn-sm" style="width: 80px;"
                        id="btn-del">
                    삭제
                </button>
            </c:if>
        </div>
        <button type="button" class="btn btn-outline-secondary btn-sm"
                style="width: 80px; margin-left: 50px;"
                onclick="location.href='./list?idx=${dto.idx}&pageNum=${pageNum}'">
            목록
        </button>

    </div>
</div>
</body>
</html>
<script>
    $("#btn-del").click(function () {
        if (confirm("삭제하시겠습니까?")) {
            $.ajax({
                type: "get",
                dataType: "text",
                url: "./deleteBoard?pageNum=" +${pageNum},
                data: {"idx":${dto.idx}, "pageNum":${pageNum}},
                success: function () {
                    location.href = "./list?pageNum=" +
                    ${pageNum}
                }
            })
        }
    })
</script>
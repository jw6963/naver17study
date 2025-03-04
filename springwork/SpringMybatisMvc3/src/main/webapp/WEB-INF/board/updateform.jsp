<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-26
  Time: 오후 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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

        .tabform tbody th {
            background-color: honeydew;
        }

        .ufiles {
            width: 40px;
            height: 40px;
            margin: 5px;
        }

        .i-del {
            color: red;
            font-size: .9em;
            position: relative;
            left: -17px;
            top: -17px;
            cursor: pointer;
        }
        .file-box {
            display: inline-block;
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

<div style="margin: 20px; width: 600px;">
    <form action="./update" method="post" enctype="multipart/form-data">
        <%--   hidden   --%>
        <input type="hidden" name="idx" value="${dto.idx}">
        <input type="hidden" name="pageNum" value="${pageNum}">
        <input type="hidden" name="regroup" value="${dto.regroup}">
        <input type="hidden" name="relevel" value="${dto.relevel}">
        <input type="hidden" name="restep" value="${dto.restep}">
        <table class="tabform table table-bordered">
            <caption align="top">
                <h5>[수정하기]</h5>
            </caption>
            <tbody>
            <tr>
                <th width="150">제 목</th>
                <td>
                    <input type="text" name="subject" class="form-control"
                           required="required" autofocus="autofocus" value="${dto.subject}">
                </td>
            </tr>
            <tr>
                <th width="150">사진 추가</th>
                <td>
                    <C:forEach var="file" items="${files}">
                        <div class="file-box">
                            <img src="${naverurl}/board/${file}" class="ufiles">
                            <i class="bi bi-x-square i-del" data-fname="${file}"></i>
                        </div>
                    </C:forEach>
                    <input type="file" name="upload" class="form-control"
                           multiple="multiple">
                </td>
            </tr>
            <tr>
                <th width="150">내 용</th>
                <td>
                    <textarea name="content" id="content" required="required"
                              style="width: 100%; height: 150px; padding: 10px;">${dto.content}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-outline-secondary"
                            style="width: 100px;">수정하기
                    </button>
                    <button type="button" class="btn btn-outline-secondary"
                            style="width: 100px;" onclick="history.back();">이전으로
                    </button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
<script>
    $(".i-del").click(function (e) {
        let fileName = $(this).data("fname");
        let filebox = $(this).closest(".file-box");
        $.ajax({
            type: "get",
            dataType: "text",
            url: "./deletePhoto",
            data: {"fileName": fileName, "idx":${dto.idx}},
            success: function () {
                // location.reload();
                filebox.remove();
            }
        })
    })
</script>
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
    </style>
</head>
<body>
<div style="margin: 30px; width: 500px;">
    <form action="./update?num=${dto.num}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="num" value="${dto.num}"></input>
        <table class="tab1 table table-boredered">
            <caption align="top"><b>상품 추가</b></caption>
            <tbody>
            <tr>
                <th width="100">상품명</th>
                <td>
                    <input type="text" name="sangpum" autofocus
                           value="${dto.sangpum}" required="required" class="form-control">
                </td>
            </tr>
            <tr>
                <th>가격</th>
                <td>
                    <input type="number" name="sprice" value="${dto.sprice}"
                           required="required" class="form-control" step="5000">
                </td>
            </tr>
            <tr>
                <th>수량</th>
                <td>
                    <input type="number" name="scnt" value="${dto.scnt}" required="required" class="form-control">
                </td>
            </tr>
            <tr>
                <th>색상</th>
                <td>
                    <input type="color" name="scolor" value="${dto.scolor}" class="form-control">
                </td>
            </tr>
            <tr>
                <th>입고일</th>
                <td>
                    <input type="date" name="ipgoday" value="${dto.ipgoday}" class="form-control">
                </td>
            </tr>
            </tbody>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-sm btn-success">수정하기</button>
                    <button type="button" class="btn btn-sm btn-success"
                            onclick="window.history.back()">돌아가기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

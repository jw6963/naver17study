<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-18
  Time: 오후 2:55
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
<div class="container">
    제목 : <input type="text" name="title" id="title"><br>
    사진 : <input type="file" name="upload" id="photo"><br>
    <hr>
    <h2 class="title"></h2>
    <div class="photo"></div>
</div>

</body>
</html>
<script>
    $("#photo").change(function (e) {
        let title = $("#title").val();
        let form = new FormData();
        form.append("upload", e.target.files[0]); // 선택한 파일 한 개
        form.append("title", title);

        $.ajax({
            type: "post",
            dataType: "json",
            url: "./munjae1process",
            processData: false,
            contentType: false,
            data: form,
            success: function (res) {
                let s = `<img src="./save/\${res.photo}">`;
                $(".photo").html(s);
                $(".title").text(res.title);
            }
        })
    })
</script>
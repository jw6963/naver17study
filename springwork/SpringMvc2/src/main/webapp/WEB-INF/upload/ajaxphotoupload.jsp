<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-18
  Time: 오후 12:03
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

        .profile {
            border: 1px solid black;
            border-radius: 100%;
            width: 200px;
            height: 200px;
        }

        #cam {
            border: 1px solid black;
            border-radius: 100%;
            font-size: 1.5em;
            padding: 5px;
            cursor: pointer;
            position: relative;
            left: -55px;
            top: 75px;
            background-color: #ddd;
        }

        #cam:hover {
            background-color: gray;
        }
    </style>
</head>
<body>
<div style="margin: 50px;">
    <div class="file-input" style="display: none">
        <input type="file" id="photoupload">
    </div>
    <img src="" id="myphoto" class="profile" onerror="this.src='./image/noimage.png'">
    <i class="bi bi-camera" id="cam"></i>

</div>
</body>
</html>
<script>
    $("#cam").click(function () {
        $("#photoupload").trigger("click");
    });
    $("#photoupload").change(function (e) {
        let form = new FormData();
        // form.append("upload",$("#photoupload")[0].files[0]); // 선택한 파일 한 개
        form.append("upload",e.target.files[0]); // 선택한 파일 한 개
        /*
        processData: false :: 서버에 전달하는 데이터는 query string이라는 형태로 전달된다.
            파일 전송의 경우 이를 하지 않아야 하는데 그 설정이 false,
        contentType: false :: enctype이 원래 기본 값이 application/x-www... 이거인데
            multipart/form-data로 변경해준다.
         */
         $.ajax({
             type:"post",
             dataType:"json",
             url:"./oneupload",
             processData: false,
             contentType:false,
             data:form,
             success:function (res) {
                 $("#myphoto").attr("src","./save/"+res.photo);
             }
         });
    });
</script>
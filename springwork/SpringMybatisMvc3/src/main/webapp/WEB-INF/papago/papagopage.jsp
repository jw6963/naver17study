<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-25
  Time: 오후 4:21
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
<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 20px; width: 600px;">
    <div style="height: 200px; border: 1px solid black;">
        <textarea name="message" id="message" cols="30" rows="10"
        style="width: 100%; height: 100%; padding: 10px;"></textarea>
    </div>
    <div class="input-group" style="width: 600px; margin-top: 10px;">
        <h5>번역할 언어를 선택하세요</h5>
        <select id="sellang" class="form-select" style="margin-left: 150px;">
            <option value="en">영어</option>
            <option value="ja">일본어</option>
            <option value="zh-CN">중국어</option>
            <option value="fr">프랑스어</option>
            <option value="de">독일어</option>
            <option value="es">스페인어</option>
        </select>
        <button type="button" class="btn btn-sm btn-success" id="btntrans"
        style="margin-left: 10px;">번역하기</button>
    </div>
    <div id="result" style="height: 200px; border: 1px solid black;
    margin-top: 20px;font-size: 1.3em; padding: 10px;"></div>
</div>
</body>
</html>
<script>
    $("#btntrans").click(function (){
        let m = $("#message").val();
        let lang = $("#sellang").val();
        $.ajax({
            type:"post",
            dataType:"json",
            data:{"message":m,"lang":lang},
            url:"./trans",
            success:function (res) {
                let transText = JSON.parse(res.text).message.result.translatedText;
                // console.log(data);
                $("#result").text(transText);
            }
        })
    });
</script>
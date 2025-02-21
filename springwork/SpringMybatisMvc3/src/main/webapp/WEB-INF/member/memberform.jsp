<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-21
  Time: 오후 12:41
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

        #showing {
            width: 130px;
            height: 160px;
            border: 1px solid gray;
        }
        .tab1 tbody th {
            background-color: #ffe4e1;
            /*color: mistyrose;*/
        }
        .addprofile {
            cursor: pointer;
        }
        .iprofile {
            font-size: 1.5em;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<div style="margin: 10px 30px; width: 500px;">
    <form action="./insert" method="post" enctype="multipart/form-data"
    onsubmit="return check()">
        <table class="table table-bordered tab1">
            <tbody>
            <tr>
                <td width="150" rowspan="5">
                    <div class="addprofile"><i class="bi bi-camera-fill iprofile"></i>&nbsp;프로필 사진</div>
                    <input type="file" name="upload" style="width: 100px; display: none"
                           onchange="preview(this)" class="profilephoto">
                    <img src="" id="showing" onerror="this.src='../save/noimage.png'">
                </td>
            </tr>
            <tr>
                <th width="70">이름</th>
                <td>
                    <input type="text" name="mname" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <th>아이디</th>
                <td class="input-group">
                    <input type="text" name="myid" id="myid" class="form-control" required="required">
                    <button type="button" class="btn btn-sm btn-danger" id="btnidcheck">중복체크</button>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td class="input-group">
                    <input type="password" name="mpass" id="mpass"
                           class="form-control" required="required" placeholder="비밀번호1">
                    <input type="password" name="mpass2" id="mpass2"
                           class="form-control" required="required" placeholder="비밀번호2">
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>
                    <input type="text" name="mhp" class="form-control" required="required">
                </td>
            </tr>
            <tr>
                <th>주 소</th>
                <td colspan="2">
                    <input type="text" name="maddr" class="form-control">
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center">
                    <button type="submit" class="btn btn-sm btn-success">회원가입</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
<script>
    $(function () {
        // 중복버튼 이벤트
        $("#btnidcheck").click(function (){
            let myid=$("#myid").val();
            $.ajax({
                type:"get",
                dataType:"json",
                data:{"myid":myid},
                url:"./idcheck",
                success:function (res){
                    if(myid=="") {
                        dupli = false;
                        alert("아이디를 입력해주세요");
                    }
                    else if(res.result=="success"){
                        dupli = true;
                        alert("사용 가능한 아이디입니다.")
                    } else {
                        dupli = false;
                        alert("이미 존재하는 아이디입니다.\n다시 입력해주세요");
                        $("#myid").val("");
                    }
                }
            })

        })
        // 아이디 입력시 중복변수 다시 false로
        $("#myid").keyup(function (){
            dupli=false;
        })
    });
    function preview(tag) {
        let f = tag.files[0];
        if (!f.type.match("image.*")) {
            alert("이미지 파일만 가능합니다");
            return;
        }
        if (f) {
            let reader = new FileReader();
            reader.onload = function (e) {
                $("#showing").attr("src", e.target.result)
            }
            reader.readAsDataURL(f);
        }
    }
    $(".addprofile").click(function (){
        $(".profilephoto").trigger("click");
    })

    let dupli = false;
    function check(){
        let p1 = $("#mpass").val();
        let p2 = $("#mpass2").val();
        if(p1 != p2) {
            alert("비밀번호가 맞지 않습니다");
            return false; // action 방지
        }
        if (!dupli) {
            alert("중복체크 버튼을 눌러주세요");
            return false;
        }
    }
</script>
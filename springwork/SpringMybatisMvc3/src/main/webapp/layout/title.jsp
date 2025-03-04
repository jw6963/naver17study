<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-21
  Time: 오전 11:48
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }

        a:link, a:visited {
            color: black;
            text-decoration-line: none;
        }

        a:hover {
            color: hotpink !important;
        }

        ul.mymenu {
            list-style: none;
            margin: 10px;
        }

        ul.mymenu li {
            float: left;
            width: 100px;
            height: 40px;
            line-height: 40px;
            text-align: center;
            background-color: #ffe4e1;
            margin-right: 10px;
            border: 1px solid gray;
            border-radius: 20px;
        }

        ul.mymenu li:hover {
            background-color: #d3d3d3;
            box-shadow: 5px 5px 5px gray;
        }

        .login-btn, .logout-btn {
            cursor: pointer;
        }

        .login-btn:hover, logout-btn:hover {
            color: hotpink;
        }

        .login-tab tbody th {
            background-color: #e0ffff;
        }

        .login-user {
            margin: 10px 50px;
            font-size: 15px;
            color: dimgray;
            background-color: lightcyan;
            padding: 15px;
            border-radius: 20px;
        }
        img.pf-photo{
            width: 40px;
            height: 40px;
            border-radius: 100px;
            border: 1px solid gray;
            cursor: pointer;
        }

    </style>
</head>
<%--프로젝트 경로 구하기 - 절대 경로를 위한 코드--%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<body>
<div class="modal" id="myLoginModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">회원 로그인</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="login-frm">
                    <table class="table table-bordered login-tab">
                        <tbody>
                        <tr>
                            <th width="80">아이디</th>
                            <td>
                                <input type="text" id="loginid" placeholder="아이디"
                                       class="form-control" required="required" autocomplete="username">
                            </td>
                        </tr>
                        <tr>
                            <th width="80">비밀번호</th>
                            <td>
                                <input type="password" id="loginpass" placeholder="비밀번호"
                                       class="form-control" required="required" autocomplete="current-password">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button type="submit" class="btn btn-success" id="doLogin">Login</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="btn-close" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<div style="margin: 10px 0 70px 0;">
    <%--    제목 클릭 시 메인 페이지로 이동 --%>
    <h2 class="alert alert-success" style="display: flex;justify-content: space-between;">
        <a href="${root}/" style="color: black; text-decoration-line: none;">
            <img src="${root}/s4.jpg" alt="" width="50">
            SpringBoot와 Mybatis를 이용한 프로젝트
        </a>
        <c:if test="${sessionScope.loginstatus!=null}">
            <c:set var="naverurl" value="https://kr.object.ncloudstorage.com/bitcamp-bucket"/>
        <span class="login-user">
<%--            <img src="${root}/save/${sessionScope.profileImg}" class="pf-photo" onerror="this.src='${root}/save/noimage.png'">--%>
            <img src="${naverurl}/member/${sessionScope.profileImg}" class="pf-photo" onerror="this.src='${root}/save/noimage.png'">
            <b style="color: black; font-size: 20px;">${sessionScope.loginid}</b> 님이 로그인중입니다.
        </span>
        </c:if>
    </h2>
    <ul class="mymenu">
        <li>
            <a href="${root}/">Home</a>
        </li>
        <li>
            <a href="${root}/naver/papago">Papago</a>
        </li>
        <li>
            <a href="${root}/shop/list">상품 목록</a>
        </li>
        <li>
            <a href="${root}/member/form">회원가입</a>
        </li>
        <c:if test="${sessionScope.loginid=='admin'}">
            <li>
                <a href="${root}/member/list">회원목록</a>
            </li>
        </c:if>
        <li>
            <a href="${root}/board/list">회원 게시판</a>
        </li>
        <li>
            <c:if test="${sessionScope.loginstatus!=null}">
                <span class="logout-btn">로그아웃</span>
            </c:if>
            <c:if test="${sessionScope.loginstatus==null}">
                <span data-bs-toggle="modal" data-bs-target="#myLoginModal"
                      class="login-btn">로그인</span>
            </c:if>
        </li>
    </ul>
</div>
<hr style="clear: both;">
</body>
</html>
<script>
    $("#login-frm").submit(function (e) {
        e.preventDefault(); // submit의 기본 이벤트를 무효화(action 호출)
        let loginid = $("#loginid").val();
        let loginpass = $("#loginpass").val();

        $.ajax({
            type: "post",
            dataType: "json",
            data: {"loginid": loginid, "loginpass": loginpass},
            url: "/member/login",
            success: function (res) {
                if (res.result == 'success') {
                    // 값 초기화
                    $("#loginid").val("");
                    $("#loginpass").val("");
                    // 모달창 닫기
                    $("#btn-close").trigger("click");
                    location.reload();
                } else {
                    alert("아이디 또는 비밀번호가 일치하지 않습니다");
                    $("#loginpass").val("");
                }
            }
        })
    })
    $(".logout-btn").click(function () {
        $.ajax({
            type: "get",
            dataType: "text",
            url: "/member/logout",
            success: function () {
                location.reload();
            }
        })
    });
    $(".pf-photo").click(function (){
       location.href=`${root}/member/mypage`;
    });
</script>
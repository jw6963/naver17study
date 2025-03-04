<%--
  Created by IntelliJ IDEA.
  User: jw
  Date: 2025-02-24
  Time: 오후 12:53
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

        .profilephoto {
            width: 150px;
            height: 150px;
            border: 1px solid gray;
            border-radius: 100px;
            position: relative;
            top: -100px;
        }

        .changecamera {
            position: relative;
            font-size: 1.4em;
            cursor: pointer;
            left: -40px;
            top: -45px;
            border-radius: 100px;
            border: 1px solid white;
            background-color: lightgrey;
            padding: 5px;
        }

        .update-tab tbody th {
            background-color: #e0ffff;
        }
        .mp-tab thead th {
            background-color: #cccccc;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("loginstatus") == null || request.getAttribute("dto") == null) {
        response.sendRedirect("/");
        return;
    }
%>
<jsp:include page="../../layout/title.jsp"/>
<div class="modal" id="myUpdateModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">회원정보 수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="update-frm">
                    <table class="table table-bordered update-tab">
                        <tbody>
                        <tr>
                            <th width="80">회원명</th>
                            <td>
                                <input type="text" id="mname-up" placeholder="회원명"
                                       class="form-control" required="required" value="${dto.mname}">
                            </td>
                        </tr>
                        <tr>
                            <th width="80">휴대폰</th>
                            <td>
                                <input type="text" id="mhp-up" placeholder="휴대폰"
                                       class="form-control" required="required" value="${dto.mhp}">
                            </td>
                        </tr>
                        <tr>
                            <th width="80">주 소</th>
                            <td>
                                <input type="text" id="maddr-up" placeholder="주 소"
                                       class="form-control" value="${dto.maddr}">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <button type="submit" class="btn btn-success" id="btn-update">수정</button>
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
<div style="margin: 30px 100px;">
    <%--    <img src="../save/${dto.mphoto}" alt="" class="profilephoto" onerror="this.src='../save/noimage.png'">--%>
    <%--    Ncp Storage에 있는 이미지로 출력--%>
    <img src="${naverurl}/member/${dto.mphoto}" alt="" class="profilephoto" onerror="this.src='../save/noimage.png'">
    <i class="bi bi-camera-fill changecamera"></i>
    <input type="file" id="fileupload" style="display: none">
    <div style="display: inline-block; margin: 20px 50px;">
        <h6>회원명 : ${dto.mname}</h6>
        <h6>아이디 : ${dto.myid}</h6>
        <h6>휴대폰 : ${dto.mhp}</h6>
        <h6>주 소 : ${dto.maddr}</h6>
        <h6>가입일 : <fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/></h6>
        <br><br>
        <button type="button" class="btn btn-sm btn-danger" onclick="memberdel(${dto.num})">회원탈퇴</button>
        <button type="button" class="btn btn-sm btn-success"
                data-bs-toggle="modal" data-bs-target="#myUpdateModal">회원정보 수정
        </button>
        <button type="button" class="btn btn-sm btn-outline-primary my-post">내가 쓴 글</button>
    </div>
    <div class="mptabbox"></div>
</div>
</body>
</html>
<script>
    $(".my-post").click(function () {
        $.ajax({
            url: "/board/myPost",
            type: "GET",
            dataType: "json",
            success: function (response) {
                let s = "";
                s += `
                <table class="table table-bordered mp-tab" style="width: 700px;">
                    <thead>
                    <th width="50"></th>
                    <th>제목</th>
                    <th width="200">작성일</th>
                    <th width="70">조회</th>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            `;
                $(".mptabbox").html(s)
                updateTable(response); // 테이블 업데이트 함수 호출
            },
        });
    });

    function updateTable(posts) {
        let tbody = $(".mp-tab tbody");
        tbody.empty(); // 기존 데이터 삭제
        if (posts.length === 0) {
            tbody.append("<tr><td colspan='4' class='text-center'>작성한 글이 없습니다.</td></tr>");
            return;
        }
        $.each(posts, function (idx, post) {
            let writeday = new Date(post.writeday).toLocaleString("ko-KR", {
                year: "numeric",
                month: "2-digit",
                day: "2-digit",
                hour: "2-digit",
                minute: "2-digit",
            });
            let row = "";
            row += `<tr>
                <td align="center">\${idx + 1}</td>
                `;
            if (post.relevel>0) {
                row+= `<td><a href="/board/detail?idx=\${post.idx}"><mark>[답글]</mark>\${post.subject}</a></td>`;
            } else {
                row+= `<td><a href="/board/detail?idx=\${post.idx}">\${post.subject}</a></td>`;
            }
            row += `
                <td style="color: gray; font-size: 13px;">\${writeday}</td>
                <td align="center" style="color: gray; font-size: 13px;">\${post.readcount}</td>
            </tr>`;
            tbody.append(row);
        });
    }

    $(function () {
        if (${sessionScope.loginstatus==null}) {
            location.href = "/";
        }
    })
    $(".changecamera").click(function () {
        $("#fileupload").trigger("click");
    })
    $("#fileupload").change(function (e) {
        let form = new FormData;
        let photo = e.target.files[0];
        form.append("upload", photo);
        form.append("num", ${dto.num});
        $.ajax({
            type: "post",
            dataType: "text",
            url: "./changephoto",
            data: form,
            processData: false,
            contentType: false,
            success: function () {
                location.reload();
            }
        })
    })

    function memberdel(num) {
        let ans = confirm("정말 탈퇴하시겠습니까?");
        if (ans) {
            $.ajax({
                type: "get",
                dataType: "text",
                data: {"num":${dto.num}},
                url: "./mypagedel",
                success: function () {
                    location.reload();
                }
            })
        }
    }

    $("#btn-update").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "post",
            dataType: "text",
            url: "./updateMember",
            data: {
                "num":${dto.num},
                "mname": $("#mname-up").val(),
                "mhp": $("#mhp-up").val(),
                "maddr": $("#maddr-up").val()
            },
            success: function () {
                location.reload();
            }
        })
    })
</script>
<%--문제: 아이디를 제외한 나머지 정보(mname,mhp,maddr)수정(모달)
수정 후 reload 할 거니까 @ResponseBody로 메서드 구현 --%>

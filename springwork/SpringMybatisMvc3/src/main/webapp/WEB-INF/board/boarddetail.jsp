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

        .replecamera {
            font-size: 1.4em;
            cursor: pointer;
            margin-left: 10px;
        }

        .replephoto img {
            width: 40px;
            height: 40px;
            border: 1px solid black;
            border-radius: 10px;
        }

        .replephotodel {
            cursor: pointer;
            top: -10px;
            left: -10px;
        }

        .replelist .profile {
            width: 30px;
            height: 30px;
            border: 1px solid gray;
            border-radius: 100px;
            margin-right: 10px;
        }

        .replelist .day {
            color: #ccc;
            font-size: 13px;
            margin-left: 10px;
        }

        .replelist .photo {
            width: 120px;
            height: 120px;
            border: 1px solid gray;
            border-radius: 10px;
            cursor: pointer;
        }

        .replelist {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="modal" id="myRepleModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">원본 사진</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <img src="" class="modal-photo" style="max-width: 100%">
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
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
    <div class="replelist"></div>
    <div style="margin-top: 30px;width: 500px;border: 1px solid gray;">
        <b style="padding: 5px;">${sessionScope.loginid}</b><br>

        <textarea style="width: 100%;height:80px;" id="message"
                  class="form-control"></textarea>

        <div class="replephoto" style="margin-bottom:10px;padding-left:10px; "></div>

        <input type="file" id="fileupload" style="display: none;">
        <i class="bi bi-camera replecamera"></i>
        <button type="button" style="border:1px solid black;float: right;margin-right: 10px;"
                id="btnreplesave">저장
        </button>

        <script>
            $(".replecamera").click(function () {
                $("#fileupload").trigger("click");
            });

            $("#fileupload").change(function (e) {
                let form = new FormData();
                form.append("upload", e.target.files[0]);
                $.ajax({
                    type: "post",
                    dataType: "text",
                    data: form,
                    processData: false,
                    contentType: false,
                    url: "./repleupload",
                    success: function (res) {
                        $(".replephoto").html(`
								<img src="${naverurl}/board/\${res}">
								<i class="bi bi-x-circle-fill replephotodel" fname="\${res}"></i>`);
                    }
                });
            });

            $(document).on("click", ".replephotodel", function () {
                let close = $(this);//x 아이콘
                let fname = close.attr("fname");
                $.ajax({
                    type: "get",
                    dataType: "text",
                    data: {"fname": fname},
                    url: "./replephotodel",
                    success: function () {
                        close.prev().remove();//x아이콘 바로 앞의 사진 삭제
                        close.remove();//자기 자신인 x아이콘도 삭제
                    }
                });
            });

            //댓글 저장
            $("#btnreplesave").click(function () {
                let idx =${dto.idx};
                let m = $("#message").val();

                $.ajax({
                    type: "post",
                    dataType: "text",
                    data: {"idx": idx, "message": m},
                    url: "./addreple",
                    success: function () {
                        //댓글 추가 성공후 초기화
                        $("#message").val("");
                        $(".replephoto").html("");
                        //추가 성공후 댓글 목록 다시 출력
                        alert("댓글 저장 성공");
                        replelist();
                    }
                });
            });
        </script>
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
    $(function(){
        replelist();

        $(document).on("click",".redel>a",function (){
            // num 읽기
            let num=$(this).attr("num");
            let ans=confirm("해당 댓글을 삭제할까요?");
            if(ans) {
                $.ajax({
                    type:"get",
                    dataType:"text",
                    data:{"num":num},
                    url:"./repledel",
                    success: function () {
                        // 댓글 삭제 후 댓글 목록 다시 출력
                        replelist();
                    }
                })
            }
        })
    });

    function replelist()
    {
        $.ajax({
            type:"get",
            dataType:"json",
            data:{"idx":${dto.idx}},
            url:"./replelist",
            success:function(res){
                let s="";
                $.each(res,function(i,item){
                    s+=`
     						<img src="${naverurl}/member/\${item.profile}" class="profile">
     						<span>\${item.writer}</span><span class="day">\${item.writeday}</span>
     						<span class="remod" style="margin-left:10px;">
     						<a href="#" style="color:gray;font-size:0.9em;" num="\${item.num}">수정</a></span>
     						<span class="redel" style="margin-left:5px;">
     						<a href="#" style="color:gray;font-size:0.9em;" num="\${item.num}">삭제</a></span>
     						<div style="margin-left:20px;">
     							<pre style="font-size:15px;">\${item.message}</pre>
     							<br>`;
                    if(item.photo!=null)
                        s+=`<img src="${naverurl}/board/\${item.photo}" class="photo"
                        data-bs-toggle="modal" data-bs-target="#myRepleModal"><br><br>`;

                    s+=`</div>`;

                });
                $(".replelist").html(s);
            }
        });
    }
    // 댓글의 작은 사진 클릭 시 원본 사진 모달로 나오게 하기
    $(document).on("click", "img.photo", function (){
        // 현재 사진 src 얻기
        let imgSrc=$(this).attr("src");
        // modal 사진에 넣기
        $(".modal-photo").attr("src",imgSrc);
    })

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
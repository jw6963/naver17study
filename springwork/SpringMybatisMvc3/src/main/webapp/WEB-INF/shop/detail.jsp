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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }

        div .p-list {
            width: 120px;
            height: 500px;
            overflow-y: auto;
            min-width: 100px;
        }

        div .p-list img {
            width: 100px;
            height: 100px;
            border: 1px solid gray;
            margin-bottom: 10px;
        }

        .photo {
            cursor: pointer;
            margin-bottom: 10px;
        }

        div .m-photo {
            height: 500px;
        }

        div .m-photo img {
            width: 400px;
            height: 500px;
            border: 3px solid black;
            margin-left: 50px;
        }

        #scolor {
            background-color: ${dto.scolor};
            width: 30px;
            height: 30px;
            border: 1px solid black;
            border-radius: 100px;
            position: relative;
            left: 150px;
            top: -30px;
        }
        .btn-group {
            margin-top: 10px;
        }

        .container {
            margin-top: 40px;
        }

        .btn1 {
            width: 120px;
            margin-right: 30px;
            border-radius: 5px;
        }

        .description {
            margin: 30px 0 30px 150px;
        }

        #photoupload {
            display: none;
        }

        .addphoto {
            font-size: 1.5em;
            cursor: pointer;
        }

        #message {
            min-width: 100px;
        }

        .repleform {
            width: 60%;
            margin-bottom: 20px;
            min-width: 400px;
        }

        .replelist {
            width: 60%;
            white-space: nowrap;
            border-top: 1px solid lightgray;
            min-width: 400px;
        }

        .rpl-con {
            margin: 20px;
            display: flex;
            align-items: center;
        }

        .rpl-photo {
            width: 40px;
            height: 40px;
            margin-right: 10px;
        }

        .rpl-msg {
            width: 430px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            margin-right: 10px;
            min-width: 50px;
        }

        .rpl-date {
            margin-right: 10px;
            font-size: 13px;
            color: gray;
        }

        .rpl-like {
            margin-right: 10px;
            color: cornflowerblue;
            cursor: pointer;
        }

        .rpl-del {
            margin-right: 10px;
            color: indianred;
            cursor: pointer;
        }
        .rpl-photo {
            cursor: pointer;
        }
    </style>
</head>
<body>
<jsp:include page="../../layout/title.jsp"/>
<%--<div style="margin: 30px;">--%>
<div class="container" style="white-space: nowrap;">
    <div style="display: flex; margin:auto;">
        <div class="p-list">
            <c:forEach var="photo" items="${photoList}">
                <img src="../save/${photo}" class="photo" onerror="this.src='../save/noimage.png'">
            </c:forEach>
        </div>
        <div class="m-photo">
            <img src="../save/${dto.mainphoto}" onerror="this.src='../save/noimage.png'">
        </div>
    </div>
    <div class="description">
        <h5>
            <mark>상품명 : ${dto.sangpum}</mark>
        </h5>
        <h5>가 격 : ${dto.sprice}</h5>
        <div style="display: flex">
            <h5>색 상 : ${dto.scolor}
                <div id="scolor"></div>
            </h5>
        </div>
        <h5>입고일 : ${dto.ipgoday}</h5>
        <h5>등록일 : <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></h5>
    </div>
    <div class="repleform input-group">
        <input type="text" id="message" class="form-control" placeholder="댓글 입력">
        <input type="file" id="photoupload">
        <i class="bi bi-camera-fill addphoto" style="margin: 0 10px 0 10px;"></i>
        <button type="button" class="btn btn-sm btn-info" id="btnaddrpl">등록</button>
    </div>
    <h5 style="color: darkslategray">댓글 : <span class="badge bg-success">${dto.replecnt}</span></h5>
    <div class="replelist">

    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-sm btn-outline-secondary btn1" id="btnRegi">상품 등록</button>
        <button type="button" class="btn btn-sm btn-outline-secondary btn1" id="btnList">목록</button>
        <button type="button" class="btn btn-sm btn-outline-secondary btn1" id="btnUpda">수정</button>
        <button type="button" class="btn btn-sm btn-outline-secondary btn1" id="btnDele">삭제</button>
        <button type="button" class="btn btn-sm btn-outline-secondary btn1" id="btnPhoEdit">사진 수정</button>
    </div>
    <div style="margin-bottom: 30px;"></div>
</div>
<%--Modal part--%>
<%--huge image modal--%>
<div class="modal" id="hui-Modal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">상세 보기</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <img src="" style="margin: auto" width="90%" class="hui-img" onerror="this.src='../save/noimage.png'">
                <hr>
                <h6 class="hui-msg"></h6>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        let photo;
        replelist();
        // 카메라 아이콘 이벤트
        $(".addphoto").click(function () {
            $("#photoupload").trigger("click");
        })
        // 파일 업로드 이벤트
        $("#photoupload").change(function (e) {
            photo = e.target.files[0];
        })
        // 댓글 등록 이벤트
        $("#btnaddrpl").click(function () {
            if (photo == null || photo == undefined || photo == "") {
                alert("사진을 등록해주세요")
            } else if ($("#message").val() == "") {
                alert("메세지를 입력해주세요")
            } else {
                let form = new FormData;
                form.append("upload", photo);
                form.append("num", ${dto.num});
                form.append("message", $("#message").val());
                $.ajax({
                    type: "post",
                    dataType: "text",
                    url: "./addreple",
                    data: form,
                    processData: false,
                    contentType: false,
                    success: function () {
                        location.reload();
                    }
                });
            }
        });
        // 메인 이미지 변경
        $(".photo").click(function () {
            $(".m-photo>img").attr("src", $(this).attr("src"));
        });
        // 등록 폼 이동
        $("#btnRegi").click(function () {
            location.href = "./addform";
        });
        // 목록 이동
        $("#btnList").click(function () {
            location.href = "./list";
        });
        // 수정 이동
        $("#btnUpda").click(function () {
            location.href = "./updateform?num=${dto.num}";
        });
        // 삭제 이동
        $("#btnDele").click(function () {
            if (confirm("삭제하겠습니까?")) {
                location.href = "./delete?num=${dto.num}";
            }
        });
        // 사진 수정 이동
        $("#btnPhoEdit").click(function () {
            location.href = "./photos?num=${dto.num}";
        });
        $(document).on("click", ".rpl-like", function () {
            let idx = $(this).closest(".rpl-con").data("idx");
            $.ajax({
                type: "get",
                dataType: "text",
                data: {"idx": idx},
                url: "./repleLike",
                success: function () {
                    location.reload();
                }
            })
        });

        $(document).on("click", ".rpl-del", function () {
            let idx = $(this).closest(".rpl-con").data("idx");
            let pname = $(this).closest(".rpl-con").find(".rpl-photo").attr("pname");
            if (confirm("삭제하시겠습니까?")) {
                $.ajax({
                    type: "get",
                    dataType: "text",
                    data: {"idx": idx, "pname": pname},
                    url: "./repleDelete",
                    success: function () {
                        location.reload();
                    }
                })
            }
        });
        $(document).on("click", ".rpl-photo", function () {
            let rc = $(this).closest(".rpl-con")
            let ph = rc.find(".rpl-photo")
            let msg = rc.find(".rpl-msg")
            // ph.attr({
            //     "data-bs-toggle": "modal",
            //     "data-bs-target": "#hui-Modal"
            // })
            $(".hui-img").attr("src",ph.attr("src"))
            $(".hui-msg").text(msg.text())
        })
    });

    function replelist() {
        $.ajax({
            type: "get",
            dataType: "json",
            data: {"num":${dto.num}},
            url: "./repleList",
            success: function (res) {
                let s = "";
                $.each(res, (idx, ele) => {
                    s += `
                    <div class="rpl-con" data-idx="\${ele.idx}">
                        <img src="../save/\${ele.photo}" pname="\${ele.photo}" class="rpl-photo"
            data-bs-toggle="modal" data-bs-target="#hui-Modal">
                        <span class="rpl-msg">\${ele.message}</span>
                        <span class="rpl-date">\${ele.writetime}</span>
                        <i class="bi bi-hand-thumbs-up-fill rpl-like">추천&nbsp;&nbsp;\${ele.likes}</i>
                        <i class="bi bi-trash-fill rpl-del">삭제</i>
                    </div>
                    <hr>
                `;
                })

                $(".replelist").html(s);
            }
        })

    }

</script>